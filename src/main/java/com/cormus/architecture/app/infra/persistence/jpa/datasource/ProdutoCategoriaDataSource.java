package com.cormus.architecture.app.infra.persistence.jpa.datasource;

import com.cormus.architecture.app.domain.entity.ProdutoCategoria;
import com.cormus.architecture.app.infra.common.converter.ProdutoCategoriaConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoriaEntity;
import com.cormus.architecture.app.infra.persistence.jpa.repository.ProdutoCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoCategoriaDataSource implements com.cormus.architecture.app.domain.common.interfaces.datasource.ProdutoCategoriaDataSource {

    @Autowired
    ProdutoCategoriaRepository produtoCategoriaRepository;

    @Override
    public ProdutoCategoria recuperarProdutoCategoriaPorId(Long idCategoria) {
        ProdutoCategoria produtoCategoria = null;
        try{
            ProdutoCategoriaEntity categoriaProduto =  this.produtoCategoriaRepository.getReferenceById(idCategoria);
            produtoCategoria = ProdutoCategoriaConverter.produtoEntityToProduto(categoriaProduto);
        } catch (Exception e){
            System.out.println("Produto categoria não encontrada");
        }
        return produtoCategoria;
    }
}
