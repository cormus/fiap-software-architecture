package com.cormus.architecture.app.domain.common.dto;

import com.cormus.architecture.app.domain.entity.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoCadastradoDTO {
    private Long id;

    private Long idCategoria;

    private String nome;

    private Double valor;

    public ProdutoCadastradoDTO(){

    }

    public ProdutoCadastradoDTO(Produto produto){
        this.id = produto.getId();
        this.idCategoria = produto.getIdCategoria();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }

    public ProdutoCadastradoDTO(Long id, Long idCategoria, String nome, Double valor){
        this.id = id;
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.valor = valor;
    }

}
