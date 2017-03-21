package lab.model.simple;

import lab.model.Country;
import lab.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
//@Entity
@Data
@Component
public class UsualPerson implements Person {
//    @Id
//    @Column
    private int id;

//    @Column
    @Value("John Smith")
    private String name;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "country_id")
    @Setter(onMethod=@__(@Autowired))
    private Country country;

    @Value("35")
    private int age;

    @Value("1.78")
    private float height;

    @Value("true")
    private boolean isProgrammer;

    @Autowired
    private List<?> contacts;

    @Override
    public void sayHello(Person person) {
    }
}