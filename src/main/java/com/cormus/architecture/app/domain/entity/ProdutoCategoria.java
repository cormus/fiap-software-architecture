package com.cormus.architecture.app.domain.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class ProdutoCategoria {

    private Long id;

    private String nome;

    private List<Produto> produtos;

    public ProdutoCategoria(Long id, String nome, List<Produto> produtos){
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }


}
