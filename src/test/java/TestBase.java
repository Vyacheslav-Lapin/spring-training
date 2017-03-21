import lab.model.Person;
import lab.model.SimpleCountry;
import lab.model.UsualPerson;

import java.util.Arrays;

interface TestBase {

    static Person getExpectedPerson() {
        return new UsualPerson(
                0,
                "John Smith",
                new SimpleCountry()
                        .id(1)
                        .name("Russia")
                        .codeName("RU"),
                35,
                1.78f,
                true,
                Arrays.asList("asd@asd.ru", "+7-234-456-67-89")
        );
    }
}
