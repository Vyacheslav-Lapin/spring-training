package lab.model.simple;

import lab.model.Customer;
import lab.model.Person;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true, fluent = true)
@Component
@Scope("prototype")
public class SimpleCustomer implements Customer {
    private long id;
    private String name;
    private boolean broke;

    @Override
    public void sayHello(Person person) {
    }
}
