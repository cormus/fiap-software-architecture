package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.dto.*;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.entity.ProdutoImagem;
import com.cormus.architecture.app.domain.entity.Usuario;
import com.cormus.architecture.app.domain.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import com.cormus.architecture.app.domain.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = "api/v1/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        List<Produto> produtos = produtoRepository.findAll().stream().map(Produto::new).toList();
        return ResponseEntity.ok(produtos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ProdutoCadastroDTO produtoDTO, UriComponentsBuilder uriBuilder){
        Produto produto = new Produto(produtoDTO);

        for (ProdutoImagemDTO imagemDto: produtoDTO.imagens()){
            ProdutoImagem imagem = new ProdutoImagem();
            imagem.setImagem(imagemDto.imagem());
            produto.addImagem(imagem);
        }

        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid ProdutoAtualizacaoDTO produtoDTO){

        Produto produto = produtoRepository.getReferenceById(produtoDTO.id());
        produto.atualizar(produtoDTO);

        return ResponseEntity.ok(new ProdutoDetalhamentoDTO(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        Produto produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new ProdutoDetalhamentoDTO(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        Produto produto = produtoRepository.getReferenceById(id);
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto com ID " + id + " não encontrado!");
        }
        return ResponseEntity.ok("Produto excluído com sucesso");
    }

}
