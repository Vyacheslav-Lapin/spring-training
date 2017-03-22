package lab.servises.simple;

import lab.dao.PersonDao;
import lab.model.Person;
import lab.servises.PersonService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimplePersonService implements PersonService {

    @Setter(onMethod = @__(@Autowired))
    private PersonDao personDao;

    @Override
    public Person getPerson(int id) {
        return personDao.getPerson(id);
    }
}
