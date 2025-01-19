package com.cormus.architecture.app.domain.repository;

import com.cormus.architecture.app.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
