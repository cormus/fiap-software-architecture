package com.cormus.architecture.app.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItem {
    private Long id;

    private int quantidade;

    private Double valor;

    private Produto produto;
}
