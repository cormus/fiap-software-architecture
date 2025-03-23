package com.cormus.architecture.app.domain.adapters.gateway;

import com.cormus.architecture.app.domain.common.interfaces.datasource.UsuarioDataSource;
import com.cormus.architecture.app.domain.entity.Usuario;

public class UsuarioGateway {

    private final UsuarioDataSource usuarioDataSource;

    public UsuarioGateway(UsuarioDataSource usuarioDataSource) {
        this.usuarioDataSource = usuarioDataSource;
    }

    public Usuario procurarPorCpf(String cpf){
        return this.usuarioDataSource.procurarPorCpf(cpf);
    }

    public Usuario procurarPorId(Long id){
        return this.usuarioDataSource.procurarPorId(id);
    }

    public Usuario cadastrar(Usuario usuario){
        return this.usuarioDataSource.cadastrar(usuario);
    }

}
