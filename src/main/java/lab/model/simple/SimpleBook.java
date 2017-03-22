package lab.model.simple;

import lab.model.Book;
import lab.model.Person;
import lombok.Value;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Accessors(fluent = true)
@Value
public class SimpleBook implements Book {
    private long id;
    private String title;
    private String comment;
    private LocalDate dateRelease;
    private Person author;
}
