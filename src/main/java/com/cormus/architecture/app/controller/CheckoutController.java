package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.dto.CheckoutDetalharDTO;
import com.cormus.architecture.app.domain.dto.PedidoCadastroDTO;
import com.cormus.architecture.app.domain.dto.PedidoItemCadastroDTO;
import com.cormus.architecture.app.domain.dto.ProdutoCadastroDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.PedidoItem;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import com.cormus.architecture.app.domain.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RestController
@RequestMapping(value = "api/v1/checkout")
public class CheckoutController {

    @Autowired
    PedidoRepository pedidoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PedidoCadastroDTO pedidoDTO){

        Pedido pedido = new Pedido();
        pedido.setIdUsuario(pedidoDTO.idUsuario());
        pedido.setStatus(PedidoStatusEnum.RECEBIDO);
        pedido.setPedidoData(LocalDateTime.now());

        for (PedidoItemCadastroDTO item : pedidoDTO.itens()) {
            PedidoItem pedidoItem = new PedidoItem(item);
            pedidoItem.setPedido(pedido);
            pedido.addItem(pedidoItem); // Garante a consistência da relação
        }

        pedidoRepository.save(pedido);
        return ResponseEntity.ok(new CheckoutDetalharDTO(pedido.getId(), "https://mercadopago.com.br/qrcode.png"));
    }

}
