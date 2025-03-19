package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.adapters.controller.ProdutoController;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastroDTO;
import com.cormus.architecture.app.infra.common.dto.ProdutoAtualizacaoRequest;
import com.cormus.architecture.app.infra.common.dto.ProdutoCadastroRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.ProdutoDataSource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "api/v1/produto")
public class ProdutoRestController {

    @Autowired
    ProdutoDataSource produtoDataSource;

    @GetMapping
    public ResponseEntity<List<ProdutoCadastradoDTO>> listar(){
        ProdutoController produtoController = new ProdutoController(this.produtoDataSource);
        List<ProdutoCadastradoDTO> produtos = produtoController.listar();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ProdutoCadastroRequest produtoCadastroRequest, UriComponentsBuilder uriBuilder){
        ProdutoCadastroDTO produtoCadastroDTO = new ProdutoCadastroDTO(produtoCadastroRequest.idCategoria(), produtoCadastroRequest.nome(), produtoCadastroRequest.valor());
        ProdutoController produtoController = new ProdutoController(this.produtoDataSource);
        ProdutoCadastradoDTO produto = produtoController.cadastrar(produtoCadastroDTO);
        return ResponseEntity.ok(produto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid ProdutoAtualizacaoRequest produtoAtualizacaoRequest){
        ProdutoCadastradoDTO produtoCadastradoDTO = new ProdutoCadastradoDTO(produtoAtualizacaoRequest.id(), produtoAtualizacaoRequest.idCategoria(), produtoAtualizacaoRequest.nome(), produtoAtualizacaoRequest.valor());
        ProdutoController produtoController = new ProdutoController(this.produtoDataSource);
        ProdutoCadastradoDTO produto = produtoController.atualizar(produtoCadastradoDTO);
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        ProdutoController produtoController = new ProdutoController(this.produtoDataSource);
        ProdutoCadastradoDTO produto = produtoController.recuperarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        ProdutoController produtoController = new ProdutoController(this.produtoDataSource);
        produtoController.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
