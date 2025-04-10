/*
 * HSLU I Module PCP ruedi.arnold@hslu.ch
 */
package ch.hslu.pcp.w8.lesson1.lambda;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String givenName;
    private String surName;

    public static class Builder {

        private String givenName = "";
        private String surName = "";

        public Person.Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Person.Builder surName(String surName) {
            this.surName = surName;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    private Person() {
        super();
    }

    private Person(Person.Builder builder) {
        givenName = builder.givenName;
        surName = builder.surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void print() {
        System.out.println("\nName: " + givenName + " " + surName);
    }

    public void printPerson() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Name: " + givenName + " " + surName;
    }

    public static List<Person> createShortList() {
        List<Person> people = new ArrayList<>();

        people.add(
                new Person.Builder()
                .givenName("Bob")
                .surName("Baker")
                .build()
        );

        people.add(
                new Person.Builder()
                .givenName("Jane")
                .surName("Joker")
                .build()
        );

        people.add(
                new Person.Builder()
                .givenName("Antony")
                .surName("Alstair")
                .build()
        );

        people.add(
                new Person.Builder()
                .givenName("Zulu")
                .surName("Zogg")
                .build()
        );

        return people;
    }

}
