package com.cormus.architecture;

import com.cormus.architecture.app.controller.PedidoRestController;
import com.cormus.architecture.app.controller.ProdutoCategoriaRestController;
import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.adapters.gateway.ProdutoCategoriaGateway;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.entity.ProdutoCategoria;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.infra.common.dto.PedidoAtualizarStatusRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.ProdutoCategoriaDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class CategoriaRestControllerTest {

    @Mock
    ProdutoCategoriaDataSource dataSource;

    @InjectMocks
    private ProdutoCategoriaGateway gateway;

    @InjectMocks
    private ProdutoCategoriaRestController controller;

    @BeforeEach
    void setup() {

        Produto produto1 = new Produto(1L);
        Produto produto2 = new Produto(2L);

        produto1.setId(1L);
        produto1.setNome("Produto 1");
        produto1.setValor(150.0);

        produto2.setId(2L);
        produto2.setNome("Produto 2");
        produto2.setValor(160.0);

        List<Produto> produtos = Arrays.asList(produto1, produto2);

        ProdutoCategoria produtoCategoria = new ProdutoCategoria(1L, "categoria", produtos);

        PedidoEntity pedidoEntity1 = new PedidoEntity();
        PedidoEntity pedidoEntity2 = new PedidoEntity();

        List<PedidoEntity> pedidosEntity = Arrays.asList(pedidoEntity1, pedidoEntity2);

        when(dataSource.recuperarProdutoCategoriaPorId(anyLong())).thenReturn(produtoCategoria);
    }

    @Test
    void testlistarProdutosPorCategoria() {

        ResponseEntity<List<ProdutoCadastradoDTO>> result = controller.listarProdutosPorCategoria(1L);

        assertEquals(2, result.getBody().size());
    }

}

