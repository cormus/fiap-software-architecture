package com.cormus.architecture.app.infra.common.dto;

import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;
import lombok.Getter;

@Getter
public class UsuarioListaDto {

    private Long id;
    private String nome;

    public UsuarioListaDto(UsuarioEntity usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }
}
