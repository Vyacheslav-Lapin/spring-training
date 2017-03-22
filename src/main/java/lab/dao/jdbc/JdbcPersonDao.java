package lab.dao.jdbc;

import lab.dao.PersonDao;
import lab.model.Person;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public class JdbcPersonDao implements PersonDao {

    @Override
    public Person getPerson(int id) {
        return null; // TODO: 03/03/2017
    }

    @Override
    public Stream<Person> getAll() {
        return null;
    }

    @Override
    public void attach(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void detach(Person person) {

    }
}
