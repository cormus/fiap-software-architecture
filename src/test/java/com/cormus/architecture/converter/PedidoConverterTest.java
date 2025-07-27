package com.cormus.architecture.converter;

import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.infra.common.converter.PedidoConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoItemEntity;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PedidoConverterTest {

    @Test
    void deveConverterPedidoEntityParaPedido() {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(1L);
        entity.setIdUsuario(10L);
        entity.setPedidoData(LocalDateTime.now());
        entity.setStatus(PedidoStatusEnum.PRONTO);
        entity.setStatus_pagamento(PagamentoStatusEnum.PAID);

        PedidoItemEntity item = new PedidoItemEntity();
        item.setId(100L);
        entity.setItens(List.of(item));

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(200L);
        produtoEntity.setNome("Produto Teste");
        produtoEntity.setValor(50.0);
        produtoEntity.setIdCategoria(1L);
        item.setProduto(produtoEntity);

        item.setProduto(produtoEntity);

        Pedido pedido = PedidoConverter.pedidoEntityToPedido(entity);

        assertNotNull(pedido);
        assertEquals(1L, pedido.getId());
        assertEquals(10L, pedido.getIdUsuario());
        assertEquals(PedidoStatusEnum.PRONTO, pedido.getStatus());
        assertEquals(PagamentoStatusEnum.PAID, pedido.getStatus_pagamento());
        assertNotNull(pedido.getPedidoData());
        assertNotNull(pedido.getItens());
        assertEquals(1, pedido.getItens().size());
    }

    @Test
    void deveConverterListaDePedidoEntityParaListaDePedido() {
        // Arrange
        PedidoEntity entity1 = new PedidoEntity();
        entity1.setId(1L);
        entity1.setIdUsuario(101L);
        entity1.setPedidoData(LocalDateTime.now());
        entity1.setStatus(PedidoStatusEnum.PRONTO);
        entity1.setStatus_pagamento(PagamentoStatusEnum.PAID);
        entity1.setItens(List.of());

        PedidoEntity entity2 = new PedidoEntity();
        entity2.setId(2L);
        entity2.setIdUsuario(102L);
        entity2.setPedidoData(LocalDateTime.now());
        entity2.setStatus(PedidoStatusEnum.PRONTO);
        entity2.setStatus_pagamento(PagamentoStatusEnum.PAID);
        entity2.setItens(List.of());

        List<PedidoEntity> lista = List.of(entity1, entity2);

        // Act
        List<Pedido> pedidos = PedidoConverter.pedidosEntityToPedidos(lista);

        // Assert
        assertNotNull(pedidos);
        assertEquals(2, pedidos.size());

        assertEquals(101L, pedidos.get(0).getIdUsuario());
        assertEquals(102L, pedidos.get(1).getIdUsuario());
    }
}
