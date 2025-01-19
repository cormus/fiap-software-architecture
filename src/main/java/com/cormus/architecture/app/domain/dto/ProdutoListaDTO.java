package com.cormus.architecture.app.domain.dto;

import com.cormus.architecture.app.domain.entity.Produto;

public class ProdutoListaDTO {

    private Long id;

    private String nome;

    private Double valor;

    public ProdutoListaDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }
}
