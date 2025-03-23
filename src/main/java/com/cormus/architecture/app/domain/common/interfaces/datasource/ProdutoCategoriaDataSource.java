package com.cormus.architecture.app.domain.common.interfaces.datasource;

import com.cormus.architecture.app.domain.entity.ProdutoCategoria;

public interface ProdutoCategoriaDataSource {
    ProdutoCategoria recuperarProdutoCategoriaPorId(Long idCategoria);
}
