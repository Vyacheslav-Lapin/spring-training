import configuration.HelloWorldConfig;
import lab.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloWorldConfig.class)
class SpringTCFAppTest {

    @Autowired
    private Person person;

    private Person expectedPerson =
            TestBase.getExpectedPerson();

    @Test
    void testInitPerson() {
        assertThat(person, is(expectedPerson));
    }
}
