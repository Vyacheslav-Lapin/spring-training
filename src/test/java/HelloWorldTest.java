import lab.model.Person;
import lab.model.SimpleCountry;
import lab.model.UsualPerson;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";
    private static final String CONTACTS_XML_FILE_NAME = "contacts.xml";

    private Person expectedPerson;

    private BeanFactory context;

    @BeforeEach
    void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(
                APPLICATION_CONTEXT_XML_FILE_NAME,
                CONTACTS_XML_FILE_NAME
        );

        expectedPerson = getExpectedPerson();
    }

    @Test
    void testInitPerson() {
        val person = context.getBean(Person.class);
        assertEquals(expectedPerson, person);
    }

    private Person getExpectedPerson() {
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
                Arrays.asList("222-33-22", "333-22-33")
        );
    }
}
