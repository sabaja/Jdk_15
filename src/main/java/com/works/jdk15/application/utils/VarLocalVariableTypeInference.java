package com.works.jdk15.application.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VarLocalVariableTypeInference {

    public static void varLocalVariable() {
        var text = "Hello Java 10";
        /*
        Cannot infer type:
            var a;
            var nothing = null;
            var lambda = () -> System.out.println("Pity!");
            var method = this::someMethod;
        * */

        var myList = new ArrayList<Map<String, List<Integer>>>();

        for (var current : myList) {
            // current is infered to type: Map<String, List<Integer>>
            System.out.println(current);
        }
    }
}
