package com.cormus.architecture.app.domain.adapters.controller;

import com.cormus.architecture.app.domain.adapters.gateway.UsuarioGateway;
import com.cormus.architecture.app.domain.adapters.presenters.UsuarioPresenter;
import com.cormus.architecture.app.domain.common.dto.UsuarioIdentificadoDTO;
import com.cormus.architecture.app.domain.common.interfaces.datasource.UsuarioDataSource;
import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.domain.usecase.UsuarioUseCase;

public class UsuarioController {

    private final UsuarioDataSource usuarioDataSource;

    public UsuarioController(UsuarioDataSource usuarioDataSource){
        this.usuarioDataSource = usuarioDataSource;
    }

    public UsuarioIdentificadoDTO procurarPorCpf(String cpf){
        UsuarioGateway usuarioGateway = new UsuarioGateway(this.usuarioDataSource);
        UsuarioUseCase usuarioUseCase = new UsuarioUseCase(usuarioGateway);
        return UsuarioPresenter.bind(usuarioUseCase.procurarPorCpf(cpf));
    }

    public UsuarioIdentificadoDTO cadastrar(Usuario usuario){
        UsuarioGateway usuarioGateway = new UsuarioGateway(this.usuarioDataSource);
        UsuarioUseCase usuarioUseCase = new UsuarioUseCase(usuarioGateway);
        return UsuarioPresenter.bind(usuarioUseCase.cadastrar(usuario));
    }

}
