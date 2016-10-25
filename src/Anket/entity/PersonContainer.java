package Anket.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonContainer implements Serializable {
    private List<Person> persons = Collections.synchronizedList(new ArrayList<>());

    public PersonContainer() {

    }

    public static void writeToFile(PersonContainer container) {
        try (ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("/home/ddexster/IdeaProjects/Anket/users.bin")))) {
            stream.writeObject(container);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PersonContainer getContainer() {
        PersonContainer container = null;
        try (ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("/home/ddexster/IdeaProjects/Anket/users.bin")))) {
            return container = ((PersonContainer) stream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new PersonContainer();
    }

    public List<Person> add(Person person) {
        this.persons.add(person);
        return this.persons;
    }

    public List<Person> remove(Person person) {
        this.persons.remove(person);
        return this.persons;
    }

    public List<Person> remove(Integer index) {
        this.persons.remove(index);
        return this.persons;
    }

    public void listItems() {
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            System.out.println(i + ". " + person.getSurmane() + " " + person.getName() + " age " + Integer.toString(person.getAge()));
        }
    }

    public boolean isPresent(Person person) {
        for (Person person1 : this.persons) {
            if (person1.equals(person)) return true;
        }
        return false;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public PersonContainer setPersons(List<Person> persons) {
        this.persons = persons;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonContainer)) return false;

        PersonContainer that = (PersonContainer) o;

        return getPersons() != null ? getPersons().equals(that.getPersons()) : that.getPersons() == null;

    }

    @Override
    public int hashCode() {
        return getPersons() != null ? getPersons().hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PersonContainer{");
        sb.append("persons=").append(persons);
        sb.append('}');
        return sb.toString();
    }
}
