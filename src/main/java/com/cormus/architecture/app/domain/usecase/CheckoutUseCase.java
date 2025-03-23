package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.PedidoGateway;
import com.cormus.architecture.app.domain.adapters.gateway.UsuarioGateway;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastroDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoItemCadastroDTO;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.PedidoItem;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;

import java.time.LocalDateTime;

public class CheckoutUseCase {

    private final PedidoGateway pedidoGateway;
    private final UsuarioGateway usuarioGateway;


    public CheckoutUseCase(PedidoGateway pedidoGateway, UsuarioGateway usuarioGateway){
        this.pedidoGateway = pedidoGateway;
        this.usuarioGateway = usuarioGateway;
    }

    public Pedido cadastrarPedido(PedidoCadastroDTO pedidoCadastroDTO){

        Usuario usuario = this.usuarioGateway.procurarPorId(pedidoCadastroDTO.getIdUsuario());
        if(usuario == null){
            throw new IllegalArgumentException("Usuário não cadastrado");
        }

        if(pedidoCadastroDTO.getItens() == null || pedidoCadastroDTO.getItens().isEmpty()){
            throw new IllegalArgumentException("Necessário informar ao menos um item no pedido");
        }

        Pedido pedido = new Pedido();
        pedido.setIdUsuario(pedidoCadastroDTO.getIdUsuario());
        pedido.setStatus(PedidoStatusEnum.RECEBIDO);
        pedido.setStatus_pagamento(PagamentoStatusEnum.WAITING);
        pedido.setPedidoData(LocalDateTime.now());

        for (PedidoItemCadastroDTO item : pedidoCadastroDTO.getItens()) {
            Produto produto = new Produto(item.getProduto().getId());

            if(item.getQuantidade() == 0){
                throw new IllegalArgumentException("Não é possível cadastrar itens com quantidade igual a zero");
            }

            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setQuantidade(item.getQuantidade());
            pedidoItem.setValor(item.getValor());
            pedidoItem.setProduto(produto);

            pedido.addItem(pedidoItem);
        }

        this.pedidoGateway.cadastrar(pedido);

        return pedido;
    }

}
