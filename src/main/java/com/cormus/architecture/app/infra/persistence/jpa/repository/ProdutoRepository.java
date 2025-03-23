package com.cormus.architecture.app.infra.persistence.jpa.repository;

import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
