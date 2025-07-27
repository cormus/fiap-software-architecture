package com.cormus.architecture.converter;

import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.entity.ProdutoCategoria;
import com.cormus.architecture.app.infra.common.converter.ProdutoCategoriaConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoriaEntity;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProdutoCategoriaConverterTest {

    @Test
    void deveConverterProdutoCategoriaEntityParaProdutoCategoria() {
        // Arrange
        ProdutoEntity produto1 = new ProdutoEntity();
        produto1.setId(1L);
        produto1.setNome("Hambúrguer");
        produto1.setIdCategoria(1L);

        ProdutoEntity produto2 = new ProdutoEntity();
        produto2.setId(2L);
        produto2.setNome("Batata");
        produto2.setIdCategoria(1L);

        ProdutoCategoriaEntity categoriaEntity = new ProdutoCategoriaEntity();
        categoriaEntity.setId(10L);
        categoriaEntity.setNome("Lanches");
        categoriaEntity.setProdutos(List.of(produto1, produto2));

        // Act
        ProdutoCategoria categoria = ProdutoCategoriaConverter.produtoEntityToProduto(categoriaEntity);

        // Assert
        assertNotNull(categoria);
        assertEquals(10L, categoria.getId());
        assertEquals("Lanches", categoria.getNome());
        assertNotNull(categoria.getProdutos());
        assertEquals(2, categoria.getProdutos().size());

        Produto produtoConvertido = categoria.getProdutos().get(0);
        assertEquals(1L, produtoConvertido.getId());
        assertEquals("Hambúrguer", produtoConvertido.getNome());
    }
}