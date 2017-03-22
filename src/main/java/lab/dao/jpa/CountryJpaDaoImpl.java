package lab.dao.jpa;

import javaslang.CheckedFunction0;
import javaslang.control.Try;
import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

    @PersistenceUnit
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(Country country) {
//        EntityManager entityManager = null;
//        EntityTransaction transaction = null;
//        try {
//            entityManager = emf.createEntityManager();
//            transaction = entityManager.getTransaction();
//            transaction.begin();
            entityManager.persist(country);
//            transaction.commit();
//        } catch (RuntimeException e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        finally {
//            if (entityManager != null)
//                entityManager.close();
//        }
    }

    @Override
    public List<Country> getAllCountries() {
        return CheckedFunction0.liftTry(emf::createEntityManager)
                .andThen(Try::get)
                .andThen(entityManager -> {
                            List<Country> countryList = entityManager
                                    .createQuery("select c from Country c", Country.class)
                                    .getResultList();
                            entityManager.close();
                            return countryList;
                        }
                ).get();
    }

    @Override
    public Country getCountryByName(String name) {
        return CheckedFunction0.liftTry(emf::createEntityManager)
                .andThen(Try::get)
                .andThen(entityManager -> {
                    Country country = entityManager
                            .createQuery(
                                    "select c from Country c where c.name like :name",
                                    Country.class)
                            .setParameter("name", name)
                            .getSingleResult();
                    entityManager.close();
                    return country;
                }).get();
    }

}
