package lab.model;

import java.time.LocalDate;

public interface Book extends DbEntity {
    String title();

    String comment();

    LocalDate dateRelease();

    Person author();
}
