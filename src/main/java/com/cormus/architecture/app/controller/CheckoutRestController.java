package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.adapters.controller.CheckoutController;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastroDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoItemCadastroDTO;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.infra.common.dto.CheckoutDetalharResponse;
import com.cormus.architecture.app.infra.common.dto.PedidoCadastroRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "api/v1/checkout")
public class CheckoutRestController {

    @Autowired
    PedidoDataSource pedidoDataSource;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PedidoCadastroRequest pedidoDTO){


        List<PedidoItemCadastroDTO> itens = pedidoDTO.itens().stream().map(item -> {
            ProdutoCadastradoDTO produtoCadastradoDTO = new ProdutoCadastradoDTO();
            produtoCadastradoDTO.setId(item.produto().getId());

            PedidoItemCadastroDTO pedidoItemCadastroDTO = new PedidoItemCadastroDTO();
            pedidoItemCadastroDTO.setQuantidade(item.quantidade());
            pedidoItemCadastroDTO.setValor(item.valor());
            pedidoItemCadastroDTO.setProduto(produtoCadastradoDTO);
            return pedidoItemCadastroDTO;
        }).toList();

        PedidoCadastroDTO pedidoCadastroDTO = new PedidoCadastroDTO();
        pedidoCadastroDTO.setIdUsuario(pedidoDTO.idUsuario());
        pedidoCadastroDTO.setItens(itens);

        CheckoutController checkoutController = new CheckoutController(this.pedidoDataSource);
        PedidoCadastradoDTO pedidoCadastrado = checkoutController.cadastrar(pedidoCadastroDTO);
        return ResponseEntity.ok(new CheckoutDetalharResponse(pedidoCadastrado.getId(), "https://mercadopago.com.br/qrcode.png"));
    }

}
