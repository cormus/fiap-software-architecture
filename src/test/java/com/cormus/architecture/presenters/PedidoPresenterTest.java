package com.cormus.architecture.presenters;

import com.cormus.architecture.app.domain.adapters.presenters.PedidoPresenter;
import com.cormus.architecture.app.domain.common.dto.CheckoutDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoItemCadastradoDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.PedidoItem;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.infra.common.dto.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PedidoPresenterTest {

    @Test
    void deveRetornarPedidoCadastradoDTOQuandoPedidoNaoForNulo() {
        Pedido pedido = new Pedido();
        pedido.setId(1L);
        pedido.setIdUsuario(100L);
        pedido.setPedidoData(LocalDateTime.now());
        pedido.setStatus(PedidoStatusEnum.PRONTO);

        PedidoCadastradoDTO dto = PedidoPresenter.bind(pedido);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals(100L, dto.getIdUsuario());
        assertEquals(PedidoStatusEnum.PRONTO, dto.getStatus());
        assertNotNull(dto.getPedidoData());
    }

    @Test
    void deveRetornarNullQuandoPedidoForNulo() {
        PedidoCadastradoDTO dto = PedidoPresenter.bind(null);
        assertNull(dto);
    }

    @Test
    void deveRetornarCheckoutDTO() {
        Pedido pedido = new Pedido();
        pedido.setId(999L);

        String qrCodeUrl = "https://pix.qrcode/teste";

        CheckoutDTO checkout = PedidoPresenter.bind(pedido, qrCodeUrl);

        assertNotNull(checkout);
        assertEquals(999L, checkout.getIdPedido());
        assertEquals(qrCodeUrl, checkout.getQrCodeUrl());
    }

    @Test
    void deveConverterListaDePedidosParaListaDePedidoCadastradoDTO() {
        Pedido p1 = new Pedido();
        p1.setId(1L);
        p1.setIdUsuario(101L);
        p1.setPedidoData(LocalDateTime.now());
        p1.setStatus(PedidoStatusEnum.PRONTO);

        Pedido p2 = new Pedido();
        p2.setId(2L);
        p2.setIdUsuario(102L);
        p2.setPedidoData(LocalDateTime.now());
        p2.setStatus(PedidoStatusEnum.PRONTO);

        List<PedidoCadastradoDTO> lista = PedidoPresenter.listBind(List.of(p1, p2));

        assertNotNull(lista);
        assertEquals(2, lista.size());
        assertEquals(1L, lista.get(0).getId());
        assertEquals(PedidoStatusEnum.PRONTO, lista.get(1).getStatus());
    }

    @Test
    void deveConverterListaDePedidoItemParaPedidoItemCadastradoDTO() {
        Produto produto = new Produto(10L, 1L, "Pizza", 45.00);

        PedidoItem item1 = new PedidoItem();
        item1.setId(1L);
        item1.setQuantidade(2);
        item1.setValor(90.00);
        item1.setProduto(produto);

        List<PedidoItemCadastradoDTO> itensDTO = PedidoPresenter.listItemBind(List.of(item1));

        assertNotNull(itensDTO);
        assertEquals(1, itensDTO.size());
        assertEquals(1L, itensDTO.get(0).getId());
        assertEquals(2, itensDTO.get(0).getQuantidade());
        assertEquals(90.00, itensDTO.get(0).getValor());
        assertNotNull(itensDTO.get(0).getProduto());
        assertEquals("Pizza", itensDTO.get(0).getProduto().getNome());
    }
}