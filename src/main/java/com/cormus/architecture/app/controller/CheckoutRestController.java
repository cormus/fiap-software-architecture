package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.adapters.controller.CheckoutController;
import com.cormus.architecture.app.domain.common.dto.*;
import com.cormus.architecture.app.infra.common.dto.CheckoutCadastroRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.UsuarioDataSource;
import com.cormus.architecture.app.infra.service.PagamentoService;
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

    @Autowired
    UsuarioDataSource usuarioDataSource;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CheckoutCadastroRequest checkoutCadastroRequest){


        List<PedidoItemCadastroDTO> itens = checkoutCadastroRequest.itens().stream().map(item -> {
            ProdutoCadastradoDTO produtoCadastradoDTO = new ProdutoCadastradoDTO();
            produtoCadastradoDTO.setId(item.produto().id());

            PedidoItemCadastroDTO pedidoItemCadastroDTO = new PedidoItemCadastroDTO();
            pedidoItemCadastroDTO.setQuantidade(item.quantidade());
            pedidoItemCadastroDTO.setValor(item.valor());
            pedidoItemCadastroDTO.setProduto(produtoCadastradoDTO);
            return pedidoItemCadastroDTO;
        }).toList();

        PedidoCadastroDTO pedidoCadastroDTO = new PedidoCadastroDTO();
        pedidoCadastroDTO.setIdUsuario(checkoutCadastroRequest.idUsuario());
        pedidoCadastroDTO.setItens(itens);

        PagamentoService pagamentoService = new PagamentoService();

        CheckoutController checkoutController = new CheckoutController(this.pedidoDataSource, this.usuarioDataSource, pagamentoService);
        CheckoutDTO pedidoCadastrado = checkoutController.cadastrar(pedidoCadastroDTO);
        return ResponseEntity.ok(pedidoCadastrado);
    }

}
