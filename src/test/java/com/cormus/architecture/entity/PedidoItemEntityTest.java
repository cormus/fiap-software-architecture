package com.cormus.architecture.entity;

import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoItemEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PedidoItemEntityTest {

    @Test
    void testGettersAndSetters() {

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setId(1L);
        pedidoEntity.setIdUsuario(2L);
        pedidoEntity.setStatus(PedidoStatusEnum.PRONTO);
        pedidoEntity.setStatus_pagamento(PagamentoStatusEnum.PAID);

        PedidoItemEntity entity = new PedidoItemEntity();
        entity.setId(1L);
        entity.setQuantidade(4);
        entity.setValor(10.5);

        assertEquals(1L, entity.getId());
        assertEquals(4, entity.getQuantidade());
        assertEquals(10.5, entity.getValor());
    }

}
