package com.amaris.futbol.Service;


import java.util.List;

public class GenericServiceImple<T> implements IGenericSerivce<T> {



    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T save(T entity) {
        return null;
    }

    @Override
    public T findById(long id) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public long count() {
        return 0;
    }


}
