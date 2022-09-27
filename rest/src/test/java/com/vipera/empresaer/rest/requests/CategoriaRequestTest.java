package com.vipera.empresaer.rest.requests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoriaRequestTest {

    CategoriaRequest categoriaRequest;

    @BeforeEach
    public void setUp(){
        categoriaRequest = new CategoriaRequest();
    }

    @Test
    void getId() {
        Long idValue = 4L;

        categoriaRequest.setId(idValue);
        assertEquals(idValue,categoriaRequest.getId());
    }

    @Test
    void getNombre() {
    }
}