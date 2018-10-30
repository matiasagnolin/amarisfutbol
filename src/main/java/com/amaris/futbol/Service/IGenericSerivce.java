package com.amaris.futbol.Service;

import java.util.List;

public interface IGenericSerivce<T> {
    List<T> findAll();
    T save(T entity);
    T findById(long id);
    void delete(T entity);
    void deleteById(long id);
    long count();
    T update(T entity);
}
