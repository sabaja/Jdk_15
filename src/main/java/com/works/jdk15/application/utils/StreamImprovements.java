package com.works.jdk15.application.utils;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    https://beginnersbook.com/2018/06/java-9-stream-api-enhancements/
*/
public interface StreamImprovements {

    static void main(String[] args) {
        //The method dropWhile() drops all the elements of the stream until the given predicate fails.
        // When the stream is unordered, the dropWhile() drops all the elements until the given predicate fails
        Stream<Integer> mystream = Stream.of(11, 22, 40, 60, 10, 15, 30, 100);
        mystream.dropWhile(num -> num < 50).forEach(System.out::println);

        //      Ordered stream
        System.out.println();
        mystream = Stream.of(11, 22, 40, 60, 10, 15, 30, 100);
        mystream.sorted().dropWhile(num -> num < 50).forEachOrdered(System.out::println);

        //      The method takeWhile() works just opposite to the dropWhile() method.
        System.out.println();
        mystream = Stream.of(11, 22, 40, 60, 10, 15, 30, 100);
        mystream.sorted().takeWhile(num -> num < 50).forEachOrdered(System.out::println);

        //      Java 9 – Stream iterate() method
        System.out.println();
        IntStream.iterate(1, num -> num < 30, num -> num * 3).forEach(System.out::println);


        //        Stream ofNullable() method
        System.out.println();
        Stream<String> stream = Stream.ofNullable(null);
        stream.forEach(str -> System.out.println("no string is printed because the stream is null" + str));

    }
}
