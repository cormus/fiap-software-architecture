package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.domain.adapters.controller.ProdutoCategoriaController;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.domain.common.interfaces.datasource.ProdutoCategoriaDataSource;
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
public class ProdutoCategoriaRestController {

    @Autowired
    ProdutoCategoriaDataSource produtoCategoriaDataSource;

//    @GetMapping("{idCategoria}/produtos")
//    public ResponseEntity<List<Produto>> listarProdutosPorCategoria(@PathVariable Long idCategoria){
//        ProdutoCategoria categoriaProduto =  categoriaRepository.getReferenceById(idCategoria);
//        return ResponseEntity.ok(categoriaProduto.getProdutos());
//    }

    @GetMapping("{idCategoria}/produtos")
    public ResponseEntity<List<ProdutoCadastradoDTO>> listarProdutosPorCategoria(@PathVariable Long idCategoria){
        ProdutoCategoriaController produtoController = new ProdutoCategoriaController(this.produtoCategoriaDataSource);
        List<ProdutoCadastradoDTO> produtos = produtoController.recuperarProdutosPorIdCategoria(idCategoria);
        return ResponseEntity.ok(produtos);
    }

}
