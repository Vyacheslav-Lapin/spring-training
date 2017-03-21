package lab.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true, fluent = true)
@Component
public class Customer implements Person {
    private String name;
    private boolean broke;

    @Override
    public void sayHello(Person person) {
    }
}
