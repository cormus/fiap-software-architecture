package com.cormus.architecture.entity;

import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoriaEntity;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProdutoCategoriaEntityTest {

    @Test
    void testGettersAndSetters() {

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(1L);
        produtoEntity.setNome("Coca-Cola");
        produtoEntity.setValor(7.5);
        produtoEntity.setIdCategoria(2L);

        List<ProdutoEntity> produtos = List.of(produtoEntity);

        ProdutoCategoriaEntity entity = new ProdutoCategoriaEntity();
        entity.setId(1L);
        entity.setNome("Bebidas");
        entity.setProdutos(produtos);

        assertEquals(1L, entity.getId());
        assertEquals("Bebidas", entity.getNome());
        assertEquals(1, entity.getProdutos().size());
    }

}

