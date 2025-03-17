package com.cormus.architecture.app.domain.adapters.gateway;

import com.cormus.architecture.app.domain.common.interfaces.datasource.ProdutoDataSource;
import com.cormus.architecture.app.domain.entity.Produto;

import java.util.List;

public class ProdutoGateway {

    ProdutoDataSource produtoDataSource;

    public ProdutoGateway(ProdutoDataSource produtoDataSource){
        this.produtoDataSource = produtoDataSource;
    }

    public Produto cadastrar(Produto produto){
        return this.produtoDataSource.cadastrar(produto);
    }

    public Produto atualizar(Produto produto){
        return this.produtoDataSource.atualizar(produto);
    }

    public List<Produto> listar() {
        return this.produtoDataSource.listar();
    }

    public Produto recuperarProdutoPorId(Long idProduto) {
        return this.produtoDataSource.recuperarProdutoPorId(idProduto);
    }

    public void excluir(Long idProduto) {
        this.produtoDataSource.excluir(idProduto);
    }
}
