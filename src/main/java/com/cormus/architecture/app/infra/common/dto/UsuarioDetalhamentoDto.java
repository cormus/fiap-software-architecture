package com.cormus.architecture.app.infra.common.dto;

import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;

public record UsuarioDetalhamentoDto(Long id, String nome) {

    public UsuarioDetalhamentoDto(UsuarioEntity usuario){
        this(usuario.getId(), usuario.getNome());
    }

}
