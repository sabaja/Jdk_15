package com.works.jdk15.application.utils;

/*
    https://medium.com/better-programming/a-look-at-the-new-switch-expressions-in-java-14-ed209c802ba0 */
public class SwitchExpressions {

    private enum Person {
        Mozart, Picasso, Goethe, Dostoevsky, Prokofiev, Dali,
        Gaudi, Bach, Einstein;
    }

    public static void print(Person person) {
        String title = switch (person) {
            case Dali, Picasso -> "painter";
            case Mozart, Prokofiev -> "composer";
            case Goethe, Dostoevsky -> "writer";
            default -> {
                System.out.printf("Oops! I don't know about %s%n", person);
                yield "...";
            }
        };

        System.out.printf("%s was a %s%n", person, title);
    }

    static int factorial(int n) {
        return switch (n) {
            case 0, 1 -> 1;
            case 2 -> 2;
            default -> factorial(n - 1) * n;
        };
    }

    public static void main(String[] args) {
        print(Person.Mozart);
        print(Person.Dali);
        print(Person.Einstein);
        System.out.println(factorial(10));
    }

}
