package com.works.jdk15.application.utils;

import java.util.stream.Stream;

/**
 * https://learnjava.co.in/java-11-string-enhancements-with-examples/
 */
public class StringStringEnhancements {

    public static void main(String[] args) {
        //strip vs trim
        String input = "   Hello   World   ";
        System.out.println("|" + input + "|");
        String output = input.strip();
        System.out.println("|" + output + "|");

        String input2 = " Hello ";
        System.out.println("Strip output:" + input2.strip());
        System.out.println("Trim output:" + input2.trim());
        input2 = '\u2001' + "Hello" + '\u2001';
        System.out.println("Strip output:" + input2.strip());
        System.out.println("Trim output:" + input2.trim());


        //stripLeading
        String input3 = " Hello World ";
        System.out.println(input3);
        String output3 = input3.stripLeading();
        System.out.println(output3);

        //stripTrailing
        String input4 = " Hello World ";
        System.out.println(input4);
        String output4 = input4.stripTrailing();
        System.out.println(output4);

        //isBlank
        String input5 = "";
        System.out.println("input.isBlank:" + input5.isBlank());
        input5 = " ";
        System.out.println("input.isBlank:" + input5.isBlank());
        input5 = " Hello World ";
        System.out.println("input.isBlank:" + input5.isBlank());
        String input6 = "";
        System.out.println("input.isBlank:" + input6.isBlank());
        input6 = " ";
        System.out.println("input.isBlank:" + input6.isBlank());
        input6 = " Hello World ";
        System.out.println("input.isBlank:" + input6.isBlank());

        //lines
        String input7 = "I am line 1.\nI am line 2. \rI am line 3.";
        Stream<String> lines = input7.lines();
        lines.forEach(System.out::println);

        //repeat
        String input8 = "Hello ";
        String output8 = input8.repeat(3);
        System.out.println(output8);
        System.out.println(input8.repeat(0));
        System.out.println(input8.repeat(3) + '\u00BF');

    }

}
