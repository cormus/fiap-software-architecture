package com.cormus.architecture.app.infra.persistence.jpa.repository;

import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Long> {
}
