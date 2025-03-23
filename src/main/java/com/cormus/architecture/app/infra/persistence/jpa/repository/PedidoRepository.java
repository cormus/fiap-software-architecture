package com.cormus.architecture.app.infra.persistence.jpa.repository;

import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<PedidoEntity, Long> {
}
