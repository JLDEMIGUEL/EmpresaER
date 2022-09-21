package com.vipera.empresaer.core.components;

import java.util.List;

public interface BaseCore<T> {

    List<T> findAll();

    T findById(Long id);

    T save(T object);

    void delete(T object);

    void deleteById(Long id);

}
