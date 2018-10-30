package com.amaris.futbol.repository;

import java.util.Optional;

public interface IGenericDAO<T,Long> {




    Optional<T> findById(Long var1);

    boolean existsById(Long var1);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<Long> var1);

    long count();

    void deleteById(Long var1);




}
