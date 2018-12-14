package com.amaris.futbol.service;


public interface IGenericSerivce<T> {
    Iterable<T> findAll();

    T save(T entity);

    T findById(long id);

    void delete(T entity);

    void deleteById(long id);

    long count();

    T update(T entity);
}
