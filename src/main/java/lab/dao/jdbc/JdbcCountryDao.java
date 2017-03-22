package lab.dao.jdbc;

import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.Optional;
import java.util.stream.Stream;

public class JdbcCountryDao extends NamedParameterJdbcDaoSupport implements CountryDao {
    private static final String GET_ALL_COUNTRIES_SQL = "SELECT id, name, code_name FROM country";
    private static final String GET_COUNTRIES_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name LIKE :name";
    private static final String UPDATE_COUNTRY_NAME_SQL = "UPDATE country SET name='%s' WHERE code_name='%s'";
    private static final String UPDATE_COUNTRY_SQL ="UPDATE country SET name='%s', code_name='%s' WHERE id=%d";
    private static final String LOAD_COUNTRIES_SQL = "INSERT INTO country (name, code_name) VALUES ('%s', '%s');";
    private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "SELECT id, name, code_name FROM country WHERE code_name = '%s'";
    private static final String GET_COUNTRY_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name = '%s'";
    private static final String DELETE_COUNTRY_BY_ID_SQL = "DELETE FROM country WHERE id=%d";

    private static final RowMapper<Country> COUNTRY_ROW_MAPPER =
            (resultSet, i) -> new SimpleCountry(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("code_name"));

    @Override
    public Stream<Country> getAll() {
        return getJdbcTemplate().query(GET_ALL_COUNTRIES_SQL, COUNTRY_ROW_MAPPER).stream();
    }

    @Override
    public void attach(Country country) {
        String sql = String.format(LOAD_COUNTRIES_SQL, country.name(), country.codeName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(sql, keyHolder);
        country.id(keyHolder.getKey().longValue());
    }

    @Override
    public void update(Country country) {

        String sql = String.format(
                UPDATE_COUNTRY_SQL,
                country.name(), country.codeName(), country.id());

        getJdbcTemplate().update(sql);
    }

    @Override
    public void detach(Country country) {
        getJdbcTemplate().update(String.format(DELETE_COUNTRY_BY_ID_SQL, country.id()));
    }

    @Override
    public Stream<Country> getCountryListStartWith(String namePrefix) {
        return getNamedParameterJdbcTemplate()
                .query(
                        GET_COUNTRIES_BY_NAME_SQL,
                        new MapSqlParameterSource("name", namePrefix + "%"),
                        COUNTRY_ROW_MAPPER)
                .stream();
    }

    @Override
    public void updateCountryName(String codeName, String newCountryName) {
        getJdbcTemplate().update(
                String.format(
                        UPDATE_COUNTRY_NAME_SQL,
                        newCountryName,
                        codeName
                ));
    }

    @Override
    public Optional<Country> getCountryByCodeName(String codeName) {
        String sql = String.format(GET_COUNTRY_BY_CODE_NAME_SQL, codeName);
        return getJdbcTemplate().query(sql, COUNTRY_ROW_MAPPER).stream().findAny();
    }

    @Override
    public Optional<Country> getCountryByName(String name) {
        return getJdbcTemplate().query(
                String.format(GET_COUNTRY_BY_NAME_SQL, name),
                COUNTRY_ROW_MAPPER)
                .stream().findAny();
    }
}
