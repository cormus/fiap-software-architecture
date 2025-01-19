package com.cormus.architecture.app.domain.repository;

import com.cormus.architecture.app.domain.entity.ProdutoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCategoriaRepository extends JpaRepository<ProdutoCategoria, Long> {
}
