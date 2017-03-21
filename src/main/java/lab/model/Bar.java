package lab.model;

import org.springframework.stereotype.Component;

@Component
public interface Bar {
    Squishy sellSquishy(Customer customer);
}