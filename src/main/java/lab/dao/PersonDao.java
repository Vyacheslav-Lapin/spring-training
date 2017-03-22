package lab.dao;

import lab.model.Person;

public interface PersonDao extends DbEntityDao<Person> {
    Person getPerson(int id);
}
