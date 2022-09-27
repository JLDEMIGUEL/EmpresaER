package com.vipera.empresaer.dao.services.categoria;

import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.dao.repositories.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
class CategoriaServiceImplTest {

    @Mock
    private CategoriaServiceImpl service;

    @Mock
    private CategoriaRepository repository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        //service = new CategoriaServiceImpl();
    }

    @Test
    void findAll() {
        List<Categoria> categoriaList = service.findAll();

    }

    @Test
    void findById() {
    }
}