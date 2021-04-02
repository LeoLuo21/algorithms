package com.wind.moon.introduction;

import java.util.Objects;

public class Person {
    private String name;
    private String address;
    private long phoneNumber;

    public Person() {
    }

    public Person(String name, String address, long phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return phoneNumber == person.phoneNumber &&
                Objects.equals(name, person.name) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber);
    }

    public static void main(String[] args) {
        Person person1 = new Person("zs","beijing",110);
        Person person2 = new Person("zs","beijing",110);

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode() == person2.hashCode());
        System.out.println(new String("hello").equals(new String("hello")));
        System.out.println(1&0x7fffffff);
        System.out.println(new Double(0).hashCode());
        System.out.println("hello".hashCode());
        System.out.println((int)'S');
    }
}
