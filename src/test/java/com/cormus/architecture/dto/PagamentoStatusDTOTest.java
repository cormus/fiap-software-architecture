package com.cormus.architecture.dto;

import com.cormus.architecture.app.domain.common.dto.PagamentoStatusDTO;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoStatusDTOTest {

    @Test
    void deveSetarEObterValoresCorretamente() {
        PagamentoStatusDTO dto = new PagamentoStatusDTO();
        dto.setIdPedido(1L);
        dto.setStatus(PagamentoStatusEnum.PAID);

        assertEquals(1L, dto.getIdPedido());
        assertEquals(PagamentoStatusEnum.PAID, dto.getStatus());
    }

    @Test
    void deveAceitarStatusNulo() {
        PagamentoStatusDTO dto = new PagamentoStatusDTO();
        dto.setIdPedido(2L);
        dto.setStatus(null);

        assertEquals(2L, dto.getIdPedido());
        assertNull(dto.getStatus());
    }
}
