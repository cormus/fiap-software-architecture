package com.cormus.architecture.usercase;


import com.cormus.architecture.app.domain.adapters.gateway.ProdutoCategoriaGateway;
import com.cormus.architecture.app.domain.usecase.ProdutoCategoriaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ProdutoCategoriaUseCaseTests {

    private ProdutoCategoriaGateway produtoCategoriaGateway;
    private ProdutoCategoriaUseCase produtoUseCase;

    @BeforeEach
    void setUp() {
        produtoCategoriaGateway = Mockito.mock(ProdutoCategoriaGateway.class);
        produtoUseCase = new ProdutoCategoriaUseCase(produtoCategoriaGateway);
    }

    @Test
    void deveLancarExcecaoQuandoCategoriaNaoForEncontrada() {
        Long idCategoriaInexistente = 999L;
        when(produtoCategoriaGateway.recuperarProdutoCategoriaPorId(idCategoriaInexistente))
                .thenReturn(null);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> produtoUseCase.recuperarProdutosPorIdCategoria(idCategoriaInexistente)
        );

        assertEquals("Categoria não encontrada", thrown.getMessage());
    }
}
