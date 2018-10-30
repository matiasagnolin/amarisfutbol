package com.amaris.futbol.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

@Repository
public abstract class GenericDAOImple<T, ID >
        implements IGenericDAO<T, ID> {

    private EntityManager entityManager;

    private Class<? extends T> daoType;

    @Override
    public Optional<T> findById(ID var1) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ID var1) {
        return false;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> var1) {
        return currentSession().createCriteria(daoType).list();

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ID var1) {
        currentSession().delete(findById(var1));
    }


    protected Session currentSession() {
        if(entityManager==null) {
            entityManager = createEntityManager();
        }

        return entityManager.unwrap(Session.class);
    }

    private EntityManager createEntityManager(){
            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("Amaris-futbol");

            return entityManagerFactory.createEntityManager();
    }
}
