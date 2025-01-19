package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.repository.PedidoRepository;
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
public class PedidosController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> listar(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos);
    }

}
