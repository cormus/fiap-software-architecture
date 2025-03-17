package com.cormus.architecture.app.infra.common.dto;

import com.cormus.architecture.app.infra.persistence.jpa.entity.Usuario;

public record UsuarioDetalhamentoDto(Long id, String nome) {

    public UsuarioDetalhamentoDto(Usuario usuario){
        this(usuario.getId(), usuario.getNome());
    }

}
