package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.adapters.controller.PagamentoController;
import com.cormus.architecture.app.domain.common.dto.PagamentoStatusDTO;
import com.cormus.architecture.app.domain.common.dto.PedidoCadastradoDTO;
import com.cormus.architecture.app.domain.enumeration.PagamentoStatusEnum;
import com.cormus.architecture.app.infra.common.dto.PagamentoAtualizarStatusRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.PedidoDataSource;
import com.cormus.architecture.app.infra.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(value = "api/v1/pagamento")
public class PagamentoRestController {

    @Autowired
    PedidoDataSource pedidoDataSource;

    @GetMapping("/{idPedido}/status")
    public ResponseEntity cadastrar(@PathVariable Long idPedido) {

        PagamentoService pagamentoService = new PagamentoService();

        PagamentoController pagamentoController = new PagamentoController(this.pedidoDataSource, pagamentoService);
        PagamentoStatusDTO status = pagamentoController.pagamentoStatusConsultar(idPedido);

        return ResponseEntity.ok(status);
    }

    @PostMapping("/webhook")
    @Transactional
    public ResponseEntity webhook(@RequestBody @Valid PagamentoAtualizarStatusRequest status) {

        PagamentoService pagamentoService = new PagamentoService();

        PagamentoStatusDTO pagamentoStatusDTO = new PagamentoStatusDTO();
        pagamentoStatusDTO.setIdPedido(status.idPedido());
        pagamentoStatusDTO.setStatus(status.status());

        PagamentoController pagamentoController = new PagamentoController(this.pedidoDataSource, pagamentoService);
        PagamentoStatusDTO pagamentoAtualizado = pagamentoController.statusPagamentoAtualizar(pagamentoStatusDTO);

        return ResponseEntity.ok(pagamentoAtualizado);
    }

}
