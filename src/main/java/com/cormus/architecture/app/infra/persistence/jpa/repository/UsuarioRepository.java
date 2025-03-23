package com.cormus.architecture.app.infra.persistence.jpa.repository;

import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Page<UsuarioEntity> findAll(Pageable paginacao);

    UserDetails findByEmail(String email);

    UsuarioEntity findByCpf(String cpf);
}
