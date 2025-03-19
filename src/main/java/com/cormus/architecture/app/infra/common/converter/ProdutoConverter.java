package com.cormus.architecture.app.infra.common.converter;

import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;

import java.util.List;

public class ProdutoConverter {

    public static Produto produtoEntityToProduto(ProdutoEntity produto ){
        return new Produto(produto.getId(), produto.getIdCategoria(), produto.getNome(), produto.getValor());
    }

    public static List<Produto> produtosEntityToProduto(List<ProdutoEntity> produtos ){
        return produtos.stream().map(produto -> new Produto(produto.getId(), produto.getIdCategoria(), produto.getNome(), produto.getValor())).toList();
    }

    public static  ProdutoEntity produtoToEntity(Produto produtoDTO){
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(produtoDTO.getId());
        produtoEntity.setIdCategoria(produtoDTO.getIdCategoria());
        produtoEntity.setNome(produtoDTO.getNome());
        produtoEntity.setValor(produtoDTO.getValor());
        return produtoEntity;
    }

}
