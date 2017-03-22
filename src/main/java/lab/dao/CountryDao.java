package lab.dao;

import lab.model.Country;
import lab.model.simple.SimpleCountry;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public interface CountryDao extends DbEntityDao<Country> {

    String[][] COUNTRY_INIT_DATA = {
            {"Australia", "AU"},
            {"Canada", "CA"},
            {"France", "FR"},
            {"Hong Kong", "HK"},
            {"Iceland", "IC"},
            {"Japan", "JP"},
            {"Nepal", "NP"},
            {"Russian Federation", "RU"},
            {"Sweden", "SE"},
            {"Switzerland", "CH"},
            {"United Kingdom", "GB"},
            {"United States", "US"}
    };

    default Stream<Country> getCountryListStartWith(String namePrefix) {
        return getAll()
                .filter(country -> country.name().startsWith(namePrefix));
    }

    default void updateCountryName(String codeName, String newCountryName) {
        getCountryByCodeName(codeName)
                .ifPresent(country -> update(country.name(newCountryName)));
    }

    default void loadCountries() {
        Arrays.stream(COUNTRY_INIT_DATA)
                .map(strings -> new SimpleCountry(strings[0], strings[1]))
                .forEachOrdered(this::attach);
    }

    default Optional<Country> getCountryByCodeName(String codeName) {
        return getAll()
                .filter(country -> country.codeName().equals(codeName))
                .findAny();
    }

    default Optional<Country> getCountryByName(String name) {
        return getAll()
                .filter(country -> country.name().equals(name))
                .findAny();
    }
}
