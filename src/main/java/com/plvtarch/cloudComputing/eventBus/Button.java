package com.plvtarch.cloudComputing.eventBus;

import java.util.HashSet;

public class Button
{
    String name;
    HashSet<Subscriber> subscribers;

    public Button(String name)
    {
        this.name = name;
        this.subscribers = new HashSet<>();
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void click()
    {
        System.out.println(name);
        for(final Subscriber sub : subscribers)
           sub.accept();
    }
}
