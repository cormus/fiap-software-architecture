package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.UsuarioGateway;
import com.cormus.architecture.app.domain.entity.Usuario;

public class UsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public UsuarioUseCase(UsuarioGateway usuarioGateway){
        this.usuarioGateway = usuarioGateway;
    }

    public Usuario procurarPorCpf(String cpf){
        Usuario usuario = this.usuarioGateway.procurarPorCpf(cpf);
        if(usuario == null){
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        return usuario;
    }

    public Usuario cadastrar(Usuario usuario){
        return this.usuarioGateway.cadastrar(usuario);
    }

}
