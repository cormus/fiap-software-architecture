package com.cormus.architecture.app.infra.persistence.jpa.repository;

import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoriaEntity, Long> {
}
