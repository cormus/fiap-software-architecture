package com.cormus.architecture.app.domain.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoCadastroDTO {
    private Long idCategoria;

    private String nome;

    private Double valor;

    public ProdutoCadastroDTO(){}

    public ProdutoCadastroDTO(Long idCategoria, String nome, Double valor){
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.valor = valor;
    }

}
