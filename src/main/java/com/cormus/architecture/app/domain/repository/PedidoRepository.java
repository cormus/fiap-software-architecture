package com.cormus.architecture.app.domain.repository;

import com.cormus.architecture.app.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}
