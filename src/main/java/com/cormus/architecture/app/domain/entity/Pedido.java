package com.cormus.architecture.app.domain.entity;

import com.cormus.architecture.app.domain.enumeration.PedidoStatusEnum;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pedido {

    private Long id;

    private Long idUsuario;

    private LocalDateTime pedidoData;

    private PedidoStatusEnum status;

    private List<PedidoItem> itens = new ArrayList<>();

    public void addItem(PedidoItem pedidoItem){
        this.itens.add(pedidoItem);
    }

}