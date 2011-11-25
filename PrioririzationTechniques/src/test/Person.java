package test;

import java.util.Set;
import java.util.HashSet;

public class Person {

    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.brothers = new HashSet();
    }

    private String name;

    private int age;

    private Set brothers;

    void addBrother(Person brother) {
        this.brothers.add(brother);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return "[Person: " + this.name + "]";
    }

    public Set getBrothers() {
        return this.brothers;
    }
}
