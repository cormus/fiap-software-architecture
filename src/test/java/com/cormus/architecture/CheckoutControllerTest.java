package com.cormus.architecture;

import com.cormus.architecture.app.controller.CheckoutRestController;
import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.adapters.gateway.UsuarioGateway;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.infra.common.dto.CheckoutCadastroRequest;
import com.cormus.architecture.app.infra.common.dto.CheckoutItemDTO;
import com.cormus.architecture.app.infra.common.dto.CheckoutProdutoDTO;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.UsuarioDataSource;
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
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class CheckoutControllerTest {

    @Mock
    PedidoDataSource pedidoDataSource;

    @Mock
    UsuarioDataSource usuarioDataSource;

    @InjectMocks
    UsuarioGateway usuarioGateway;

    @InjectMocks
    PedidoGateway pedidoGateway;


    @InjectMocks
    CheckoutRestController controller;

    @BeforeEach
    void setup() {
        Usuario usuario = new Usuario();
        Pedido pedido = new Pedido();
        when(usuarioDataSource.procurarPorId(any())).thenReturn(usuario);
        when(pedidoDataSource.cadastrar(any())).thenReturn(pedido);
    }

    @Test
    void testCadastrar() {
        CheckoutProdutoDTO produto = new CheckoutProdutoDTO(1L);

        List<CheckoutItemDTO> itens = Arrays.asList(
                new CheckoutItemDTO(1, 1.1, produto),
                new CheckoutItemDTO(2, 2.1, produto)
        );

        CheckoutCadastroRequest checkoutCadastroRequest = mock(CheckoutCadastroRequest.class);
        when(checkoutCadastroRequest.idUsuario()).thenReturn(1L);
        when(checkoutCadastroRequest.itens()).thenReturn(itens);

        ResponseEntity result = controller.cadastrar(checkoutCadastroRequest);

        assertEquals(200, result.getStatusCodeValue());
    }

}

