package lab.model;

public interface Person {
    Person name(String name);
    String name();
    void sayHello(Person person);
}