package com.cormus.architecture.app.infra.persistence.jpa.datasource;

import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.PedidoItem;
import com.cormus.architecture.app.infra.common.converter.PedidoConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoItemEntity;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import com.cormus.architecture.app.infra.persistence.jpa.repository.PedidoRepository;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.util.List;

@Component
public class PedidoDataSource implements com.cormus.architecture.app.domain.common.interfaces.datasource.PedidoDataSource {

    private final PedidoRepository pedidoRepository;

    PedidoDataSource(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> listar() {
        List<PedidoEntity> pedidos = this.pedidoRepository.findAll();
        return PedidoConverter.pedidosEntityToPedidos(pedidos);
    }

    @Override
    public Pedido cadastrar(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdUsuario(pedido.getIdUsuario());
        pedidoEntity.setStatus(pedido.getStatus());
        pedidoEntity.setStatus_pagamento(pedido.getStatus_pagamento());
        pedidoEntity.setPedidoData(pedido.getPedidoData());

        for (PedidoItem pedidoItem : pedido.getItens()) {
            ProdutoEntity produtoEntity = new ProdutoEntity();
            produtoEntity.setId(pedidoItem.getProduto().getId());

            PedidoItemEntity pedidoItemEntity = new PedidoItemEntity();
            pedidoItemEntity.setQuantidade(pedidoItem.getQuantidade());
            pedidoItemEntity.setValor(pedidoItem.getValor());
            pedidoEntity.addItem(pedidoItemEntity);
            pedidoItemEntity.setProduto(produtoEntity);
        }

        this.pedidoRepository.save(pedidoEntity);
        pedido.setId(pedidoEntity.getId());
        return pedido;
    }

    @Override
    public Pedido pedidoPorId(Long idPedido) {
        Pedido pedido = null;

        try{
            PedidoEntity pedidoEntity = this.pedidoRepository.getReferenceById(idPedido);
            pedido = PedidoConverter.pedidoEntityToPedido(pedidoEntity);
        } catch (Exception e){
            System.out.println(e);
        }

        return pedido;
    }

    @Override
    public Pedido statusPagamentoAtualizar(Pedido pedido) {

        PedidoEntity pedidoEntity = null;

        try{
            pedidoEntity = this.pedidoRepository.getReferenceById(pedido.getId());
            pedidoEntity.setStatus_pagamento(pedido.getStatus_pagamento());
        } catch (Exception e){
            System.out.println(e);
        }

        return PedidoConverter.pedidoEntityToPedido(pedidoEntity);
    }


    @Override
    public Pedido statusPedidoAtualizar(Pedido pedido) {

        PedidoEntity pedidoEntity = null;

        try{
            pedidoEntity = this.pedidoRepository.getReferenceById(pedido.getId());
            pedidoEntity.setStatus(pedido.getStatus());
        } catch (Exception e){
            System.out.println(e);
        }

        return PedidoConverter.pedidoEntityToPedido(pedidoEntity);
    }
}
