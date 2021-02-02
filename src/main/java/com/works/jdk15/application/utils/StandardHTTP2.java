package com.works.jdk15.application.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

@Slf4j
public class StandardHTTP2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest getRequest =
                HttpRequest.newBuilder()
                        .uri(URI.create("https://advancedweb.hu/"))
                        .timeout(Duration.of(10, SECONDS))
                        .GET()
                        .build();

        HttpResponse<String> response =
                httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
      log.info(String.valueOf(response));

    }
}
