package com.cormus.architecture.app.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class Produto {

    private Long id;

    private Long idCategoria;

    private String nome;

    private Double valor;

    private LocalDateTime dataExclusao;

    public Produto(Long id){
        if(id == null){
            throw new IllegalArgumentException("Produto inválido");
        }
        this.id = id;
    }

    public Produto(Long id, Long idCategoria, String nome, Double valor){

        if(!validarNome(nome) || !validarCategoria(idCategoria)){
            throw new IllegalArgumentException("Produto inválido");
        }

        this.id = id;
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.valor = valor;
    }

    private boolean validarNome(String nome){
        return nome == null || !nome.trim().isEmpty();
    }

    private boolean validarCategoria(Long idCategoria){
        return idCategoria != null && idCategoria > 0;
    }
}
