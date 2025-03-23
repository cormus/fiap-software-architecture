package com.cormus.architecture.app.domain.common.interfaces.datasource;

import com.cormus.architecture.app.domain.entity.Produto;

import java.util.List;

public interface ProdutoDataSource {
    Produto cadastrar(Produto produto);
    Produto atualizar(Produto produto);
    List<Produto> listar();
    Produto recuperarProdutoPorId(Long idProduto);
    void excluir(Long idProduto);
}
