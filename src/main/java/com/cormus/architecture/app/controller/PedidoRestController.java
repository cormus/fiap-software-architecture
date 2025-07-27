package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.adapters.controller.PagamentoController;
import com.cormus.architecture.app.domain.adapters.controller.PedidoController;
import com.cormus.architecture.app.domain.common.dto.PagamentoStatusDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.infra.common.dto.PagamentoAtualizarStatusRequest;
import com.cormus.architecture.app.infra.common.dto.PedidoAtualizarStatusRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoCadastradoDTO> pedido(@PathVariable Long idPedido){
        PedidoController pedidoController = new PedidoController(this.pedidoDataSource);
        return ResponseEntity.ok(pedidoController.pedidoPorId(idPedido));
    }

    @PutMapping("/status")
    @Transactional
    public ResponseEntity statusPedidoAtualizar(@RequestBody @Valid PedidoAtualizarStatusRequest status) {

        PedidoCadastradoDTO pedidoCadastradoDTO = new PedidoCadastradoDTO();
        pedidoCadastradoDTO.setId(status.idPedido());
        pedidoCadastradoDTO.setStatus(status.status());

        PedidoController pedidoController = new PedidoController(this.pedidoDataSource);
        PedidoCadastradoDTO pagamentoAtualizado = pedidoController.statusPedidoAtualizar(pedidoCadastradoDTO);

        return ResponseEntity.ok(pagamentoAtualizado);
    }
}
