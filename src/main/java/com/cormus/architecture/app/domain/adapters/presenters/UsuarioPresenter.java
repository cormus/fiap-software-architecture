package com.cormus.architecture.app.domain.adapters.presenters;

import com.cormus.architecture.app.domain.common.dto.UsuarioIdentificadoDTO;
import com.cormus.architecture.app.domain.entity.Usuario;

public class UsuarioPresenter {

    public static UsuarioIdentificadoDTO bind(Usuario usuario){
        UsuarioIdentificadoDTO usuarioIdentificadoDTO = new UsuarioIdentificadoDTO();
        usuarioIdentificadoDTO.setId(usuario.getId());
        usuarioIdentificadoDTO.setNome(usuario.getNome());
        return usuarioIdentificadoDTO;
    }

}
