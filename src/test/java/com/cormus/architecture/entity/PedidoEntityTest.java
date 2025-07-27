package com.cormus.architecture.entity;

import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PedidoEntityTest {

    @Test
    void testGettersAndSetters() {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(1L);
        entity.setIdUsuario(2L);
        entity.setStatus(PedidoStatusEnum.PRONTO);
        entity.setStatus_pagamento(PagamentoStatusEnum.PAID);

        assertEquals(1L, entity.getId());
        assertEquals(2L, entity.getIdUsuario());
        assertEquals("PRONTO", entity.getStatus().toString());
        assertEquals("PAID", entity.getStatus_pagamento().toString());
    }

}

