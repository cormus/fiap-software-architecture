package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.ProdutoCategoriaGateway;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.entity.ProdutoCategoria;

import java.util.List;

public class ProdutoCategoriaUseCase {

    private final ProdutoCategoriaGateway produtoCategoriaGateway;

    public ProdutoCategoriaUseCase(ProdutoCategoriaGateway produtoCategoriaGateway){
        this.produtoCategoriaGateway = produtoCategoriaGateway;
    }

    public List<Produto> recuperarProdutosPorIdCategoria(Long idProdutoCategoria) {
        ProdutoCategoria produtoCategoria = this.produtoCategoriaGateway.recuperarProdutoCategoriaPorId(idProdutoCategoria);
        if(produtoCategoria == null){
            throw new IllegalArgumentException("Categoria não encontrada");
        }
        return produtoCategoria.getProdutos();
    }

}
