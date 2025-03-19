package com.cormus.architecture.app.infra.common.converter;

import com.cormus.architecture.app.domain.entity.ProdutoCategoria;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoriaEntity;

public class ProdutoCategoriaConverter {

    public static ProdutoCategoria produtoEntityToProduto(ProdutoCategoriaEntity produtoCategoriaEntity ){
        return new ProdutoCategoria(
                    produtoCategoriaEntity.getId(),
                    produtoCategoriaEntity.getNome(),
                    ProdutoConverter.produtosEntityToProduto(produtoCategoriaEntity.getProdutos())
                  );
    }

}
