package com.cormus.architecture.app.domain.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemCadastroDTO {
    private int quantidade;

    private Double valor;

    private ProdutoCadastradoDTO produto;
}
