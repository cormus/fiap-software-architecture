package com.cormus.architecture.datasource;

import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.entity.ProdutoCategoria;
import com.cormus.architecture.app.infra.common.converter.ProdutoCategoriaConverter;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.ProdutoCategoriaDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoriaEntity;
import com.cormus.architecture.app.infra.persistence.jpa.repository.ProdutoCategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockedStatic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoCategoriaDataSourceTest {

    @Mock
    private ProdutoCategoriaRepository produtoCategoriaRepository;

    @InjectMocks
    private ProdutoCategoriaDataSource produtoCategoriaDataSource;

    @Test
    void testRecuperarProdutoCategoriaPorId_found() {

        Produto produto = new Produto(1L);
        List<Produto> produtos = List.of(produto);

        Long id = 1L;
        ProdutoCategoriaEntity entity = mock(ProdutoCategoriaEntity.class);
        ProdutoCategoria categoria = new ProdutoCategoria(1L, "Categoria teste", produtos);

        when(produtoCategoriaRepository.getReferenceById(id)).thenReturn(entity);

        try (MockedStatic<ProdutoCategoriaConverter> converter = mockStatic(ProdutoCategoriaConverter.class)) {
            converter.when(() -> ProdutoCategoriaConverter.produtoEntityToProduto(entity)).thenReturn(categoria);

            ProdutoCategoria result = produtoCategoriaDataSource.recuperarProdutoCategoriaPorId(id);

            assertNotNull(result);
            assertEquals(categoria, result);
        }
    }

    @Test
    void testRecuperarProdutoCategoriaPorId_notFound() {
        Long id = 2L;
        when(produtoCategoriaRepository.getReferenceById(id)).thenThrow(new RuntimeException("Not found"));

        ProdutoCategoria result = produtoCategoriaDataSource.recuperarProdutoCategoriaPorId(id);

        assertNull(result);
    }
}