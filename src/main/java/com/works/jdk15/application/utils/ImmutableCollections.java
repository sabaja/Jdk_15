package com.works.jdk15.application.utils;

import java.util.List;
import java.util.Map;

/*
* https://winterbe.com/posts/2018/09/24/java-11-tutorial/*/
public class ImmutableCollections {

    public static void main(String[] args) {
        var list = List.of("A", "B", "C");
        var copy = List.copyOf(list);
        System.out.println(list == copy);   // true

        var map = Map.of("A", 1, "B", 2);
        System.out.println(map);    // {B=2, A=1}
    }
}
