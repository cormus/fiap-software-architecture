package com.cormus.architecture.app.domain.adapters.presenters;

import com.cormus.architecture.app.domain.common.dto.*;
import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.PedidoItem;

import java.util.List;

public class PedidoPresenter {

    public static PedidoCadastradoDTO bind(Pedido pedido){
        if(pedido != null) {
            PedidoCadastradoDTO pedidoCadastradoDTO = new PedidoCadastradoDTO();
            pedidoCadastradoDTO.setId(pedido.getId());
            pedidoCadastradoDTO.setIdUsuario(pedido.getIdUsuario());
            pedidoCadastradoDTO.setPedidoData(pedido.getPedidoData());
            pedidoCadastradoDTO.setStatus(pedido.getStatus());
            //pedidoCadastradoDTO.setItens(PedidoPresenter.listItemBind(pedido.getItens()));
            return pedidoCadastradoDTO;
        }
        return null;
    }

    public  static CheckoutDTO bind(Pedido pedido, String qrCodeUrl){
        CheckoutDTO checkoutDTO = new CheckoutDTO();
        checkoutDTO.setIdPedido(pedido.getId());
        checkoutDTO.setQrCodeUrl(qrCodeUrl);
        return checkoutDTO;
    }

    public static List<PedidoCadastradoDTO> listBind(List<Pedido> pedidos){
        return pedidos.stream().map(PedidoPresenter::bind).toList();
    }

    public static List<PedidoItemCadastradoDTO> listItemBind(List<PedidoItem> itens){
        return itens.stream().map(item -> {
            PedidoItemCadastradoDTO pedidoItemCadastradoDTO = new PedidoItemCadastradoDTO();
            pedidoItemCadastradoDTO.setId(item.getId());
            pedidoItemCadastradoDTO.setQuantidade(item.getQuantidade());
            pedidoItemCadastradoDTO.setValor(item.getValor());

            ProdutoCadastradoDTO produtoCadastradoDTO = new ProdutoCadastradoDTO(item.getProduto());
            pedidoItemCadastradoDTO.setProduto(produtoCadastradoDTO);

            return pedidoItemCadastradoDTO;
        }).toList();
    }

}
