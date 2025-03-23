package com.cormus.architecture.app.domain.common.interfaces.datasource;

import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.infra.persistence.jpa.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioDataSource {
    Usuario procurarPorCpf(String cpf);

    Usuario cadastrar(Usuario usuario);

    Usuario procurarPorId(Long id);
}
