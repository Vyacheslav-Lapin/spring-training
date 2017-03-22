import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
//@Log4j
class CountryDaoImplTest {

	private Country exampleCountry = new SimpleCountry("Australia", "AU");

	@Autowired
	private CountryDao countryDao;

	@Test
	void testSaveCountry() {

		countryDao.attach(exampleCountry);

		List<Country> countryList = countryDao.getAll().collect(Collectors.toList());
		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
	void testGtAllCountries() {
		countryDao.attach(new SimpleCountry("Canada", "CA"));
		assertEquals(2, countryDao.getAll().count());
	}

	@Test
	void testGetCountryByName() {
		val country = countryDao.getCountryByName("Australia");
		assertTrue(country.isPresent());
		assertEquals(exampleCountry, country.get());
	}

}
