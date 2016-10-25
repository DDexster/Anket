package Anket.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String surmane;
    private int age;

    public Person() {
    }

    public Person(String name, String surmane, int age) {
        this.name = name;
        this.surmane = surmane;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurmane() {
        return surmane;
    }

    public Person setSurmane(String surmane) {
        this.surmane = surmane;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getAge() != person.getAge()) return false;
        if (!getName().equals(person.getName())) return false;
        return getSurmane().equals(person.getSurmane());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurmane().hashCode();
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surmane='").append(surmane).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
