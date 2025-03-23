package com.cormus.architecture.app.domain.adapters.gateway;

import com.cormus.architecture.app.domain.common.interfaces.datasource.ProdutoCategoriaDataSource;
import com.cormus.architecture.app.domain.entity.ProdutoCategoria;

public class ProdutoCategoriaGateway {

    ProdutoCategoriaDataSource produtoCategoriaDataSource;

    public ProdutoCategoriaGateway(ProdutoCategoriaDataSource produtoCategoriaDataSource){
        this.produtoCategoriaDataSource =  produtoCategoriaDataSource;
    }

    public ProdutoCategoria recuperarProdutoCategoriaPorId(Long idProdutoCategoria){
        return this.produtoCategoriaDataSource.recuperarProdutoCategoriaPorId(idProdutoCategoria);
    }

}
