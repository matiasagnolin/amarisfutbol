package com.amaris.futbol.service;

import org.springframework.transaction.annotation.Transactional;

import com.amaris.futbol.repository.IGenericDAO;

@Transactional
public abstract class GenericServiceImple<T> implements IGenericSerivce<T> {

    private IGenericDAO<T, Long> genericDAO;

    /**
     * @return Returns the genericDAO.
     */
    public IGenericDAO<T, Long> getGenericDAO() {
        return genericDAO;
    }

    public void setGenericDAO(final IGenericDAO<T, Long> genericDAO) {
        this.genericDAO = genericDAO;
    }

    @Override
    public Iterable<T> findAll() {
        return genericDAO.findAll();
    }

    @Override
    public T save(final T entity) {
        return null;
    }

    @Override
    public T findById(final long id) {
        return null;
    }

    @Override
    public void delete(final T entity) {

    }

    @Override
    public void deleteById(final long id) {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public T update(final T entity) {
        return null;
    }
}
