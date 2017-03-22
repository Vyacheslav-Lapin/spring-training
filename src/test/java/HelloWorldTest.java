import lab.model.Person;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class HelloWorldTest {

    private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";
    private BeanFactory context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);
    private Person expectedPerson = TestBase.getExpectedPerson();

    @Test
    void testInitPerson() {
        val person = context.getBean("person", Person.class);
        assertThat(person, is(expectedPerson));
    }
}
