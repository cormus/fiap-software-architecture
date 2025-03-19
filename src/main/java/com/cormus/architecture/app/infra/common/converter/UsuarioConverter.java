package com.cormus.architecture.app.infra.common.converter;

import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.infra.persistence.jpa.entity.EnderecoVO;
import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;
import jakarta.persistence.Embedded;

public class UsuarioConverter {

    public static Usuario usuarioEntityParaUsuario(UsuarioEntity usuarioEntity){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioEntity.getId());
        usuario.setNome(usuarioEntity.getNome());
        usuario.setTelefone(usuarioEntity.getTelefone());
        usuario.setEmail(usuarioEntity.getEmail());
        usuario.setCpf(usuarioEntity.getCpf());
        usuario.setSenha(usuarioEntity.getSenha());
        usuario.setEndereco(usuarioEntity.getEndereco());
        return usuario;

    }

}
