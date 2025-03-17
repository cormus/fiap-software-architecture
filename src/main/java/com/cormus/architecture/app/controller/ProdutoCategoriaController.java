package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoria;
//import com.cormus.architecture.app.infra.persistence.jpa.entity.Produto;
import com.cormus.architecture.app.infra.persistence.jpa.repository.ProdutoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "api/v1/produto-categoria")
public class ProdutoCategoriaController {

    @Autowired
    ProdutoCategoriaRepository categoriaRepository;

//    @GetMapping("{idCategoria}/produtos")
//    public ResponseEntity<List<Produto>> listarProdutosPorCategoria(@PathVariable Long idCategoria){
//        ProdutoCategoria categoriaProduto =  categoriaRepository.getReferenceById(idCategoria);
//        return ResponseEntity.ok(categoriaProduto.getProdutos());
//    }

}
