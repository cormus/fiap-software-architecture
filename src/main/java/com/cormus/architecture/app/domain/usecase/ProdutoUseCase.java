package com.cormus.architecture.app.domain.usecase;

import com.cormus.architecture.app.domain.adapters.gateway.ProdutoGateway;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastroDTO;
import com.cormus.architecture.app.domain.entity.Produto;

import java.util.List;

public class ProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public ProdutoUseCase(ProdutoGateway produtoGateway){
        this.produtoGateway = produtoGateway;
    }

    public Produto cadastrar(ProdutoCadastroDTO produtoCadastroDTO){
        Produto produto = new Produto(null, produtoCadastroDTO.getIdCategoria(), produtoCadastroDTO.getNome(), produtoCadastroDTO.getValor());
        return this.produtoGateway.cadastrar(produto);
    }

    public Produto atualizar(ProdutoCadastradoDTO produtoCadastradoDTO){
        Produto produto = new Produto(produtoCadastradoDTO.getId(), produtoCadastradoDTO.getIdCategoria(), produtoCadastradoDTO.getNome(), produtoCadastradoDTO.getValor());
        return this.produtoGateway.atualizar(produto);
    }

    public List<Produto> listar(){
        return this.produtoGateway.listar();
    }

    public Produto recuperarProdutoPorId(Long idProduto){
        Produto produto =  this.produtoGateway.recuperarProdutoPorId(idProduto);
        if(produto == null){
            throw new IllegalArgumentException("Produto não encontrado");
        }
        return produto;
    }

    public void excluir(Long idProduto){
        Produto produto = this.recuperarProdutoPorId(idProduto);
        if(produto == null){
            throw new IllegalArgumentException("Produto não encontrado");
        }
        this.produtoGateway.excluir(idProduto);
    }
}
