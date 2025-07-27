package com.cormus.architecture.usercase;

import com.cormus.architecture.app.domain.adapters.gateway.ProdutoCategoriaGateway;
import com.cormus.architecture.app.domain.adapters.gateway.ProdutoGateway;
import com.cormus.architecture.app.domain.usecase.ProdutoCategoriaUseCase;
import com.cormus.architecture.app.domain.usecase.ProdutoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoUseCaseTests {

    private ProdutoGateway gateway;
    private ProdutoUseCase useCase;

    @BeforeEach
    void setUp() {
        gateway = Mockito.mock(ProdutoGateway.class);
        useCase = new ProdutoUseCase(gateway);
    }

    @Test
    void testProdutoNaoEncontrado() {
        Long id = 999L;
        when(gateway.recuperarProdutoPorId(anyLong())).thenReturn(null);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> useCase.recuperarProdutoPorId(id)
        );

        assertEquals("Produto não encontrado", thrown.getMessage());
    }

    @Test
    void testProdutoNaoEncontradoExcluir() {
        Long id = 999L;
        when(gateway.recuperarProdutoPorId(anyLong())).thenReturn(null);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> useCase.excluir(id)
        );

        assertEquals("Produto não encontrado", thrown.getMessage());
    }
}
