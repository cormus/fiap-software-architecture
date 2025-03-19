package com.cormus.architecture.app.infra.persistence.jpa.datasource;

import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.infra.common.converter.ProdutoConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoEntity;
import com.cormus.architecture.app.infra.persistence.jpa.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoDataSource implements com.cormus.architecture.app.domain.common.interfaces.datasource.ProdutoDataSource {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produto cadastrar(Produto produto) {
        ProdutoEntity produtoEntity = ProdutoConverter.produtoToEntity(produto);
        this.produtoRepository.save(produtoEntity);
        return ProdutoConverter.produtoEntityToProduto(produtoEntity);
    }

    @Override
    public Produto atualizar(Produto produto) {
        ProdutoEntity produtoAtualizarEntity = ProdutoConverter.produtoToEntity(produto);
        ProdutoEntity produtoEntity = this.produtoRepository.getReferenceById(produto.getId());
        produtoEntity.atualizar(produtoAtualizarEntity);
        return ProdutoConverter.produtoEntityToProduto(produtoEntity);
    }

    @Override
    public List<Produto> listar() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtos.stream().map(ProdutoConverter::produtoEntityToProduto).toList();
    }

    @Override
    public Produto recuperarProdutoPorId(Long idProduto) {
        Produto produto = null;
        try {
            ProdutoEntity produtoEntity = this.produtoRepository.getReferenceById(idProduto);
            produto = ProdutoConverter.produtoEntityToProduto(produtoEntity);
        } catch (Exception e){
            System.out.println("Produto não encontrado");
        }
        return produto;
    }

    @Override
    public void excluir(Long idProduto) {
        this.produtoRepository.deleteById(idProduto);
    }
}
