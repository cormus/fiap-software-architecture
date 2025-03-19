package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.adapters.controller.PedidoController;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "api/v1/pedido")
public class PedidoRestController {

    @Autowired
    PedidoDataSource pedidoDataSource;

    @GetMapping
    public ResponseEntity<List<PedidoCadastradoDTO>> listar(){
        PedidoController pedidoController = new PedidoController(this.pedidoDataSource);
        return ResponseEntity.ok(pedidoController.listar());
    }

}
