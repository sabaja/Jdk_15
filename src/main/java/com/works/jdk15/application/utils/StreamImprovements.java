package com.works.jdk15.application.utils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    https://beginnersbook.com/2018/06/java-9-stream-api-enhancements/
*/
public interface StreamImprovements {

    static void main(String[] args) {

        HttpClient httpClient = new HttpClient() {
            @Override
            public Optional<CookieHandler> cookieHandler() {
                return Optional.empty();
            }

            @Override
            public Optional<Duration> connectTimeout() {
                return Optional.empty();
            }

            @Override
            public Redirect followRedirects() {
                return null;
            }

            @Override
            public Optional<ProxySelector> proxy() {
                return Optional.empty();
            }

            @Override
            public SSLContext sslContext() {
                return null;
            }

            @Override
            public SSLParameters sslParameters() {
                return null;
            }

            @Override
            public Optional<Authenticator> authenticator() {
                return Optional.empty();
            }

            @Override
            public Version version() {
                return null;
            }

            @Override
            public Optional<Executor> executor() {
                return Optional.empty();
            }

            @Override
            public <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler) throws IOException, InterruptedException {
                return null;
            }

            @Override
            public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler) {
                return null;
            }

            @Override
            public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler, HttpResponse.PushPromiseHandler<T> pushPromiseHandler) {
                return null;
            }
        };
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
