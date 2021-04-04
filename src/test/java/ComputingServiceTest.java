import com.plvtarch.cloudComputing.service.ComputingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ComputingServiceTest
{
    private static ComputingService computingService;

    @BeforeAll
    static void createConnection() {
        computingService = new ComputingService();
    }

    static Stream<Arguments> intLists() {
        return Stream.of(
                arguments(Arrays.asList(3,3,4,2,5)),
                arguments(Arrays.asList(322,5,12,111)),
                arguments(Arrays.asList(11,59,23,1000,1))
        );
    }

    static Stream<Arguments> stringsLists() {
        return Stream.of(
                arguments(Arrays.asList("bbbbbbbbbb", "ddd", "ccccccc", "b", "aaa", "cccc", "c")),
                arguments(Arrays.asList("aaa", "bb", "bbbbb", "aaaaaa", "eeeeeeee")),
                arguments(Arrays.asList("hhhhhhhhhhhh", "bbb", "b", "aaa", "ccccccccc", "hhhhh", "hhh", "q"))
        );
    }

    @ParameterizedTest
    @MethodSource("intLists")
    void testSum(List<Integer> integerList)
    {

        assertEquals(integerList
                .stream()
                .mapToInt(Integer::intValue)
                .sum(), computingService.sum(integerList));
    }

    @Test
    void testButtons()
    {
        computingService.eventBus();
    }

    @ParameterizedTest
    @MethodSource("stringsLists")
    void testGroup(List<String> testStrings)
    {
        assertTrue(computingService.grouping(testStrings).length() > 0);
    }
}
