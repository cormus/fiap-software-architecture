package com.cormus.architecture.datasource;

import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.PedidoItem;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.entity.*;
import com.cormus.architecture.app.infra.persistence.jpa.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class PedidoDataSourceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoDataSource pedidoDataSource;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(1L);
        when(pedidoRepository.getReferenceById(eq(1L))).thenReturn(pedidoEntity);
    }

    @Test
    void deveListarPedidos() {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(1L);
        entity.setStatus(PedidoStatusEnum.RECEBIDO);
        entity.setStatus_pagamento(PagamentoStatusEnum.PAID);
        entity.setIdUsuario(10L);

        when(pedidoRepository.findAll()).thenReturn(List.of(entity));

        List<Pedido> pedidos = pedidoDataSource.listar();

        assertNotNull(pedidos);
        assertEquals(0, pedidos.size());
    }

    @Test
    void deveCadastrarPedido() {
        Pedido pedido = new Pedido();
        pedido.setIdUsuario(1L);
        pedido.setStatus(PedidoStatusEnum.RECEBIDO);
        pedido.setStatus_pagamento(PagamentoStatusEnum.PAID);
        pedido.setPedidoData(LocalDateTime.now());

        Produto produto = new Produto(1L);
        produto.setId(100L);

        PedidoItem item = new PedidoItem();
        item.setQuantidade(2);
        item.setValor(15.0);
        item.setProduto(produto);

        pedido.setItens(List.of(item));

        PedidoEntity savedEntity = new PedidoEntity();
        savedEntity.setId(99L);

        when(pedidoRepository.save(any(PedidoEntity.class))).thenReturn(savedEntity);

        Pedido resultado = pedidoDataSource.cadastrar(pedido);

        assertNotNull(resultado);
    }

    @Test
    void deveRetornarPedidoPorId() {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(1L);
        entity.setIdUsuario(123L);

        when(pedidoRepository.getReferenceById(anyLong())).thenReturn(entity);

        Pedido resultado = pedidoDataSource.pedidoPorId(1L);

        assertNotNull(resultado);
    }

    @Test
    void statusPedidoAtualizar(){
        PedidoEntity entity = new PedidoEntity();
        entity.setId(1L);
        entity.setStatus(PedidoStatusEnum.RECEBIDO);
        entity.setStatus_pagamento(PagamentoStatusEnum.PAID);
        entity.setIdUsuario(123L);

        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setStatus(PedidoStatusEnum.PRONTO);

        when(pedidoRepository.getReferenceById(eq(1L))).thenReturn(entity);

        Pedido pedidoRetorno = pedidoDataSource.statusPedidoAtualizar(pedido);

        assertNotNull(pedidoRetorno);
    }


}