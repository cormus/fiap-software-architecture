package com.cormus.architecture.app.infra.common.dto;

import com.cormus.architecture.app.domain.entity.Produto;

public record ProdutoDetalhamentoDTO(Long id, String nome, Double valor) {

    public ProdutoDetalhamentoDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getValor());
    }

}