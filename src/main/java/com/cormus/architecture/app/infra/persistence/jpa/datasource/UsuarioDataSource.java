package com.cormus.architecture.app.infra.persistence.jpa.datasource;

import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.infra.common.converter.UsuarioConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;
import com.cormus.architecture.app.infra.persistence.jpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDataSource implements com.cormus.architecture.app.domain.common.interfaces.datasource.UsuarioDataSource {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario procurarPorCpf(String cpf){
        UsuarioEntity usuario = this.usuarioRepository.findByCpf(cpf);
        return UsuarioConverter.usuarioEntityParaUsuario(usuario);
    }

    @Override
    public Usuario cadastrar(Usuario usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setCpf(usuario.getCpf());
        this.usuarioRepository.save(usuarioEntity);
        return UsuarioConverter.usuarioEntityParaUsuario(usuarioEntity);
    }

}
