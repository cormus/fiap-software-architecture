package com.cormus.architecture.usercase;

import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.adapters.gateway.ProdutoCategoriaGateway;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.domain.usecase.PedidoUseCase;
import com.cormus.architecture.app.domain.usecase.ProdutoCategoriaUseCase;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class PedidoUseCaseTest {

    @Mock
    PedidoDataSource pedidoDataSource;

    @InjectMocks
    private PedidoUseCase pedidoUseCase;

    @InjectMocks
    private PedidoGateway pedidoGateway;

    @BeforeEach
    void setUp() {
        pedidoUseCase = new PedidoUseCase(pedidoGateway);
    }

    @Test
    void statusPedidoAtualizar_statusCancelado(){

        Pedido pedido = new Pedido();
        pedido.setStatus(PedidoStatusEnum.CANCELADO);

        when(pedidoDataSource.pedidoPorId(anyLong())).thenReturn(pedido);

        PedidoCadastradoDTO pedidoCadastradoDTO = new PedidoCadastradoDTO();
        pedidoCadastradoDTO.setId(1L);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> pedidoUseCase.statusPedidoAtualizar(pedidoCadastradoDTO)
        );

        assertEquals("Não foi possível atualizar o status: Pedido cancelado.", thrown.getMessage());
    }

    @Test
    void statusPedidoAtualizar_pagamentoPendente(){

        Pedido pedido = new Pedido();
        pedido.setStatus_pagamento(PagamentoStatusEnum.CANCELED);

        when(pedidoDataSource.pedidoPorId(anyLong())).thenReturn(pedido);

        PedidoCadastradoDTO pedidoCadastradoDTO = new PedidoCadastradoDTO();
        pedidoCadastradoDTO.setId(1L);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> pedidoUseCase.statusPedidoAtualizar(pedidoCadastradoDTO)
        );

        assertEquals("Aguardando confirmação de pagamento: Só é possível atualizar o status dos pedidos com pagamento confirmado.", thrown.getMessage());
    }
}
