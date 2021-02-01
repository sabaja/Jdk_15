package com.works.jdk15.application.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StandardHTTP2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create("https://advancedweb.hu/"))
                        .GET()
                        .build();

        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
