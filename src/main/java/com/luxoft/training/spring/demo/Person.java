package com.luxoft.training.spring.demo;import lombok.*;import lombok.extern.java.Log;import java.util.Arrays;@RequiredArgsConstructor@Value@Logpublic class Person {    private final int age;    private final String name;    private final boolean isFemale;    @SneakyThrows    public static void main(String[] args) {        val person = new Person(1, "Вася", false);        Class.forName("com.luxoft.training.spring.demo.Address");        Arrays.asList("1", "2", "3", "4").stream()                .parallel()                .map(Integer::parseInt)                .filter(integer -> integer % 2 == 0)                .forEach(System.out::println);    }    private static String m1(boolean isNull) {        return isNull ? null : "Мама мыла раму";    }}