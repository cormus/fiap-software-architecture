package com.cormus.architecture.app.domain.common.dto;

import com.cormus.architecture.app.domain.entity.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemCadastradoDTO {
    private Long id;

    private int quantidade;

    private Double valor;

    private ProdutoCadastradoDTO produto;
}
