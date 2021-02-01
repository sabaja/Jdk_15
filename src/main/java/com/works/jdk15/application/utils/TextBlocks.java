package com.works.jdk15.application.utils;

import lombok.Getter;

@Getter
public class TextBlocks {

    private static final String html = """
            <html>
                <body>
                    <p>Hello, world</p>
                </body>
            </html>
            """;


    public static void printHtml(){
        System.out.println(html);
    }

    public static void main(String[] args) {
        TextBlocks.printHtml();
    }
}
