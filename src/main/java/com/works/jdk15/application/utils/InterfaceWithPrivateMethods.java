package com.works.jdk15.application.utils;

import org.springframework.util.NumberUtils;

import java.math.BigInteger;

public interface InterfaceWithPrivateMethods<T extends Number> {

    private BigInteger retrieveBigIntegerFromNumbers(T number) {
        return NumberUtils.convertNumberToTargetClass(number, BigInteger.class);
    }

    default BigInteger convertNumberToTargetClass(T number) {
        return this.retrieveBigIntegerFromNumbers(number);
    }

    default void print(T number){
        System.out.println(convertNumberToTargetClass(number));
    }

    class StaticDoubleClazz implements InterfaceWithPrivateMethods<Double>{
    }

    class StaticIntegerClazz implements InterfaceWithPrivateMethods<Integer>{
    }

    static void main(String[] args) {

        StaticDoubleClazz doubleClazz = new StaticDoubleClazz();
        doubleClazz.print(10D);
        StaticIntegerClazz integerClazz = new StaticIntegerClazz();
        integerClazz.print(10);
    }
}
