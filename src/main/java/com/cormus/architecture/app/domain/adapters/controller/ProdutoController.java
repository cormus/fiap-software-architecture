package com.cormus.architecture.app.domain.adapters.controller;

import com.cormus.architecture.app.domain.adapters.gateway.ProdutoGateway;
import com.cormus.architecture.app.domain.adapters.presenters.ProdutoPresenter;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastroDTO;
import com.cormus.architecture.app.domain.common.interfaces.datasource.ProdutoDataSource;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.usecase.ProdutoUseCase;

import java.util.List;

public class ProdutoController {

    //controlles trabalham com DTO
    //use case recebe dto transforma em objeto produto
    //envia par ao gateway um objeto produto

    private final ProdutoDataSource produtoDataSource;

    public ProdutoController(ProdutoDataSource produtoDataSource) {
        this.produtoDataSource = produtoDataSource;
    }

    public ProdutoCadastradoDTO cadastrar(ProdutoCadastroDTO produtoCadastroDTO){
        ProdutoGateway produtoGateway = new ProdutoGateway(this.produtoDataSource);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        Produto produto =  produtoUseCase.cadastrar(produtoCadastroDTO);
        return ProdutoPresenter.bind(produto);
    }

    public ProdutoCadastradoDTO atualizar(ProdutoCadastradoDTO produtoCadastradoDTO){
        ProdutoGateway produtoGateway = new ProdutoGateway(this.produtoDataSource);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        Produto produto = produtoUseCase.atualizar(produtoCadastradoDTO);
        return ProdutoPresenter.bind(produto);
    }

    public List<ProdutoCadastradoDTO> listar(){
        ProdutoGateway produtoGateway = new ProdutoGateway(this.produtoDataSource);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        List<Produto> produtos =  produtoUseCase.listar();
        return ProdutoPresenter.listBind(produtos);
    }

    public ProdutoCadastradoDTO recuperarProdutoPorId(Long idProduto){
        ProdutoGateway produtoGateway = new ProdutoGateway(this.produtoDataSource);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        Produto produto = produtoUseCase.recuperarProdutoPorId(idProduto);
        return ProdutoPresenter.bind(produto);
    }

    public void excluir(Long idProduto){
        ProdutoGateway produtoGateway = new ProdutoGateway(this.produtoDataSource);
        ProdutoUseCase produtoUseCase = new ProdutoUseCase(produtoGateway);
        produtoUseCase.excluir(idProduto);
    }

}
