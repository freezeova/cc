package com.plvtarch.cloudComputing.service;

import com.plvtarch.cloudComputing.eventBus.Button;
import com.plvtarch.cloudComputing.eventBus.Subscriber;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ComputingService
{
    public int sum(List<Integer> array)
    {
        return array.size() == 0 ?
                0 : sum(array.subList(1,array.size())) + array.get(0);
    }

    public String grouping(List<String> strings)
    {
         return strings
                 .stream()
                 .map(x -> x.trim().charAt(0))
                 .map(x ->
                         strings
                                 .stream()
                                 .filter(y -> y
                                            .contains(x.toString()))
                                            .max(Comparator.naturalOrder())
                                            .orElseThrow(() -> new NullPointerException("")) )
                 .distinct()
                 .sorted(Comparator.comparing(String::length).reversed())
                 .collect(Collectors.toMap(
                         i -> i,
                         String::length,
                         (e1, e2) -> e1,
                         LinkedHashMap::new
                 ))
                 .toString();
    }

    public void eventBus()
    {
        Button button1 = new Button("B1");
        Button button2 = new Button("B2");
        Subscriber subscriber1 = () -> System.out.println("Sub1");
        Subscriber subscriber2 = () -> System.out.println("Sub2");
        Subscriber subscriber3 = () -> System.out.println("Sub3");

        button1.subscribe(subscriber1);
        button1.subscribe(subscriber2);
        button2.subscribe(subscriber3);

        button1.click();
        button2.click();

        button1.unsubscribe(subscriber1);

        button1.click();
        button2.click();
    }

}
