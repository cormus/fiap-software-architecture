package com.cormus.architecture.datasource;

import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.infra.common.converter.ProdutoConverter;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.ProdutoDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import com.cormus.architecture.app.infra.persistence.jpa.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoDataSourceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoDataSource produtoDataSource;

    @Test
    void testCadastrar() {
        Produto produto = new Produto(1L);
        ProdutoEntity entity = mock(ProdutoEntity.class);

        try (MockedStatic<ProdutoConverter> converter = mockStatic(ProdutoConverter.class)) {
            converter.when(() -> ProdutoConverter.produtoToEntity(produto)).thenReturn(entity);
            converter.when(() -> ProdutoConverter.produtoEntityToProduto(entity)).thenReturn(produto);

            when(produtoRepository.save(entity)).thenReturn(entity);

            Produto result = produtoDataSource.cadastrar(produto);

            assertEquals(produto, result);
            verify(produtoRepository).save(entity);
        }
    }

    @Test
    void testAtualizar() {
        Produto produto = new Produto(1L);
        produto.setId(1L);
        ProdutoEntity entity = mock(ProdutoEntity.class);
        ProdutoEntity entityAtualizar = mock(ProdutoEntity.class);

        try (MockedStatic<ProdutoConverter> converter = mockStatic(ProdutoConverter.class)) {
            converter.when(() -> ProdutoConverter.produtoToEntity(produto)).thenReturn(entityAtualizar);
            when(produtoRepository.getReferenceById(1L)).thenReturn(entity);
            converter.when(() -> ProdutoConverter.produtoEntityToProduto(entity)).thenReturn(produto);

            Produto result = produtoDataSource.atualizar(produto);

            verify(entity).atualizar(entityAtualizar);
            assertEquals(produto, result);
        }
    }

    @Test
    void testListar() {
        ProdutoEntity entity1 = mock(ProdutoEntity.class);
        ProdutoEntity entity2 = mock(ProdutoEntity.class);
        Produto produto1 = new Produto(1L);
        Produto produto2 = new Produto(1L);

        when(produtoRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

        try (MockedStatic<ProdutoConverter> converter = mockStatic(ProdutoConverter.class)) {
            converter.when(() -> ProdutoConverter.produtoEntityToProduto(entity1)).thenReturn(produto1);
            converter.when(() -> ProdutoConverter.produtoEntityToProduto(entity2)).thenReturn(produto2);

            List<Produto> result = produtoDataSource.listar();

            assertEquals(2, result.size());
            assertTrue(result.contains(produto1));
            assertTrue(result.contains(produto2));
        }
    }

    @Test
    void testRecuperarProdutoPorId_found() {
        Long id = 1L;
        ProdutoEntity entity = mock(ProdutoEntity.class);
        Produto produto = new Produto(1L);

        when(produtoRepository.getReferenceById(id)).thenReturn(entity);

        try (MockedStatic<ProdutoConverter> converter = mockStatic(ProdutoConverter.class)) {
            converter.when(() -> ProdutoConverter.produtoEntityToProduto(entity)).thenReturn(produto);

            Produto result = produtoDataSource.recuperarProdutoPorId(id);

            assertEquals(produto, result);
        }
    }

    @Test
    void testRecuperarProdutoPorId_notFound() {
        Long id = 2L;
        when(produtoRepository.getReferenceById(id)).thenThrow(new RuntimeException("Not found"));

        Produto result = produtoDataSource.recuperarProdutoPorId(id);

        assertNull(result);
    }

    @Test
    void testExcluir() {
        Long id = 1L;
        produtoDataSource.excluir(id);
        verify(produtoRepository).deleteById(id);
    }
}