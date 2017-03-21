package lab.model.simple;

import lab.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Accessors(chain = true, fluent = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@EqualsAndHashCode(exclude = "id")
public class SimpleCountry implements Country {

    @Value("1")
	private int id;

	@Value("Russia")
    private String name;

	@Value("RU")
    private String codeName;

    public SimpleCountry(String name, String codeName) {
        this.name = name;
        this.codeName = codeName;
    }
}
