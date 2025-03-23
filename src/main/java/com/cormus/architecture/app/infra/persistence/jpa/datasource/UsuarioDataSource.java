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
        Usuario usuario = null;
        try {
            UsuarioEntity usuarioEntity = this.usuarioRepository.findByCpf(cpf);
            usuario = UsuarioConverter.usuarioEntityParaUsuario(usuarioEntity);
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
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

    @Override
    public Usuario procurarPorId(Long id) {
        Usuario usuario = null;
        try {
            UsuarioEntity usuarioEntity = this.usuarioRepository.getReferenceById(id);
            usuario = UsuarioConverter.usuarioEntityParaUsuario(usuarioEntity);
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
    }

}
