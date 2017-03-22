package lab.model;

public interface Person extends DbEntity {

    String name();

    default void sayHello(Person person) {
        System.out.printf("Hello, %s", person.name());
    }
}
