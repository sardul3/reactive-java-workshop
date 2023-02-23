package io.javabrains.reactiveworkshop;

import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()
        Stream<Integer> numbers = StreamSources.intNumbersStream();
        Stream<User> users = StreamSources.userStream();

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(number -> number < 5)
                .forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream().filter(num -> num > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream().map(user -> user.getFirstName()).forEach(fn -> System.out.println(fn));

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().anyMatch(number -> number == user.getId()))
                .forEach(System.out::println);

    }

}
