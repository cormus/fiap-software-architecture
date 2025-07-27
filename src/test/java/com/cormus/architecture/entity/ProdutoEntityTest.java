package com.cormus.architecture.entity;

import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
@ActiveProfiles("test")
class ProdutoEntityTest {

    @Test
    void testGettersAndSetters() {
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(1L);
        entity.setNome("Coca-Cola");
        entity.setValor(7.5);
        entity.setIdCategoria(2L);

        assertEquals(1L, entity.getId());
        assertEquals("Coca-Cola", entity.getNome());
        assertEquals(7.5, entity.getValor());
        assertEquals(2L, entity.getIdCategoria());
    }

    @Test
    void testAtualizar(){
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(1L);
        entity.setNome("Coca-Cola");
        entity.setValor(7.5);
        entity.setIdCategoria(2L);

        assertEquals("Coca-Cola", entity.getNome());
    }

}


