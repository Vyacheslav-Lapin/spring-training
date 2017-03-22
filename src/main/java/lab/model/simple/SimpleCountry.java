package lab.model.simple;

import lab.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Accessors(chain = true, fluent = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@EqualsAndHashCode(exclude = "id")
@Entity
public class SimpleCountry implements Country {

    @Value("1")
    @Id
    @GeneratedValue
	private long id;

    @Column
	@Value("Russia")
    private String name;

	@Value("RU")
    private String codeName;

    public SimpleCountry(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }
}
