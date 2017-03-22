package lab.dao.jpa;

import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class JpaCountryDao extends JpaDao implements CountryDao {

    @Override
    public void attach(Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(country);
        transaction.commit();

        em.close();
    }

    @Override
    public void update(Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.merge(country);
        transaction.commit();

        em.close();
    }

    @Override
    public void detach(Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.detach(country);
        transaction.commit();

        em.close();
    }

    @Override
    public Stream<Country> getAll() {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.createQuery("select c from lab.model.simple.SimpleCountry c", Country.class)
                .getResultList().stream();
    }// getAllcountries()

//    @Override
//    public Optional<Country> getCountryByName(String name) {
////		TODO: Implement it
//
//        return null;
//    }

}
