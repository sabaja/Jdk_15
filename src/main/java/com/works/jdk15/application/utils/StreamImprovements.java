package com.works.jdk15.application.utils;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    https://beginnersbook.com/2018/06/java-9-stream-api-enhancements/
*/
public interface StreamImprovements {

    static void main(String[] args) {
        //The method dropWhile() drops all the elements of the stream until the given predicate fails.
        // When the stream is unordered, the dropWhile() drops all the elements until the given predicate fails
        Stream<Integer> integerStream = Stream.of(11, 22, 40, 60, 10, 15, 30, 100);
        integerStream.dropWhile(num -> num < 50).forEach(System.out::println);

        //      Ordered stream
        System.out.println();
        integerStream = Stream.of(11, 22, 40, 60, 10, 15, 30, 100);
        integerStream.sorted().dropWhile(num -> num < 50).forEachOrdered(System.out::println);

        //      The method takeWhile() works just opposite to the dropWhile() method.
        System.out.println();
        integerStream = Stream.of(11, 22, 40, 60, 10, 15, 30, 100);
        integerStream.sorted().takeWhile(num -> num < 50).forEachOrdered(System.out::println);

        //      Java 9 – Stream iterate() method
        System.out.println();
        IntStream.iterate(1, num -> num < 30, num -> num * 3).forEach(System.out::println);


        //        Stream ofNullable() method
        System.out.println();
        Stream<String> stream = Stream.ofNullable(null);
        stream.forEach(str -> System.out.println("no string is printed because the stream is null" + str));

        //https://4comprehension.com/java-immutable-unmodifiable-stream-api-collectors/
        //Immutable/Unmodifiable Stream API Collectors
        //Before JDK 10
        var unmodifiableList = Stream.of(42)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        unmodifiableList.forEach(System.out::print);

        //https://4comprehension.com/java-immutable-unmodifiable-stream-api-collectors/
        //After JDK 10
        var collect = Stream.of(42)
                .collect(Collectors.toUnmodifiableList());
        collect.forEach(System.out::print);
    }
}
