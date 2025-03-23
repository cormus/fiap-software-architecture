package com.cormus.architecture.app.domain.adapters.controller;

import com.cormus.architecture.app.domain.adapters.gateway.ProdutoCategoriaGateway;
import com.cormus.architecture.app.domain.adapters.presenters.ProdutoPresenter;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.domain.common.interfaces.datasource.ProdutoCategoriaDataSource;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.usecase.ProdutoCategoriaUseCase;

import java.util.List;

public class ProdutoCategoriaController {

    private final ProdutoCategoriaDataSource produtoCategoriaDataSource;

    public ProdutoCategoriaController(ProdutoCategoriaDataSource produtoCategoriaDataSource) {
        this.produtoCategoriaDataSource = produtoCategoriaDataSource;
    }

    public List<ProdutoCadastradoDTO> recuperarProdutosPorIdCategoria(Long idProdutoCategoria){
        ProdutoCategoriaGateway produtoCategoriaGateway = new ProdutoCategoriaGateway(this.produtoCategoriaDataSource);
        ProdutoCategoriaUseCase rodutoCategoriaUseCase = new ProdutoCategoriaUseCase(produtoCategoriaGateway);
        List<Produto> produtos = rodutoCategoriaUseCase.recuperarProdutosPorIdCategoria(idProdutoCategoria);
        return ProdutoPresenter.listBind(produtos);
    }


}
