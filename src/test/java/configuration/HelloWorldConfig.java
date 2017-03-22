package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("person.properties")
@ImportResource(locations = "application-context.xml")
@ComponentScan(basePackages = "lab.model")
public class HelloWorldConfig {

    @Autowired
    Environment env;

//    @Bean
//    public Person person() {
//        return new SimplePerson(
//                Integer.parseInt(env.getProperty("id", "0")),
//                env.getProperty("name", "John Doe"),
//                Float.parseFloat(env.getProperty("height", "1.78f")),
//                Integer.parseInt(env.getProperty("age")),
//                env.getProperty("programmer").equalsIgnoreCase("true"));
//    }

//    @Bean
//    public List<String> contacts() {
//        return Arrays.asList("1", "asd@asd.ru", "+7-234-456-67-89");
//    }

//    @Bean
//    public SimpleCountry country() {
//        return new SimpleCountry(1, "Russia", "RU");
//    }
}