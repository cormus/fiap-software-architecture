package com.cormus.architecture.converter;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.infra.common.converter.ProdutoConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProdutoConverterTest {

    @Test
    void deveConverterProdutoEntityParaProduto() {
        // Arrange
        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(10L);
        entity.setIdCategoria(2L);
        entity.setNome("Hamburguer");
        entity.setValor(15.90);

        // Act
        Produto produto = ProdutoConverter.produtoEntityToProduto(entity);

        // Assert
        assertNotNull(produto);
        assertEquals(10L, produto.getId());
        assertEquals(2L, produto.getIdCategoria());
        assertEquals("Hamburguer", produto.getNome());
        assertEquals(15.90, produto.getValor());
    }

    @Test
    void deveConverterListaDeProdutoEntityParaListaDeProduto() {
        // Arrange
        ProdutoEntity entity1 = new ProdutoEntity();
        entity1.setId(1L);
        entity1.setIdCategoria(100L);
        entity1.setNome("Refrigerante");
        entity1.setValor(7.00);

        ProdutoEntity entity2 = new ProdutoEntity();
        entity2.setId(2L);
        entity2.setIdCategoria(101L);
        entity2.setNome("Batata Frita");
        entity2.setValor(9.50);

        List<ProdutoEntity> entidades = List.of(entity1, entity2);

        // Act
        List<Produto> produtos = ProdutoConverter.produtosEntityToProduto(entidades);

        // Assert
        assertNotNull(produtos);
        assertEquals(2, produtos.size());

        Produto produto1 = produtos.get(0);
        assertEquals("Refrigerante", produto1.getNome());
        assertEquals(7.00, produto1.getValor());

        Produto produto2 = produtos.get(1);
        assertEquals("Batata Frita", produto2.getNome());
        assertEquals(9.50, produto2.getValor());
    }

    @Test
    void deveConverterProdutoParaProdutoEntity() {
        // Arrange
        Produto produto = new Produto(3L, 200L, "Pizza", 29.90);

        // Act
        ProdutoEntity entity = ProdutoConverter.produtoToEntity(produto);

        // Assert
        assertNotNull(entity);
        assertEquals(3L, entity.getId());
        assertEquals(200L, entity.getIdCategoria());
        assertEquals("Pizza", entity.getNome());
        assertEquals(29.90, entity.getValor());
    }
}