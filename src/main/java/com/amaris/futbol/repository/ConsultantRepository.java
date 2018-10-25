package com.amaris.futbol.repository;


import com.amaris.futbol.domain.Player;

import java.util.Optional;


public class ConsultantRepository<Consultant,Long> implements IPlayerRepository<Consultant,Long> {


    @Override
    public <S extends Consultant> S save(S s) {
        return null;
    }

    @Override
    public <S extends Consultant> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }


    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Consultant> findAll() {
        return null;
    }

    @Override
    public Iterable<Consultant> findAllById(Iterable<Long> iterable) {
        return null;
    }


    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Consultant consultant) {

    }

    @Override
    public void deleteAll(Iterable<? extends Consultant> iterable) {

    }


    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<Consultant> findById(Long aLong) {
        return Optional.empty();
    }
}
