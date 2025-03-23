package com.cormus.architecture.app.domain.adapters.presenters;

import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.domain.entity.Produto;

import java.time.LocalDateTime;
import java.util.List;

public class ProdutoPresenter {

    public static ProdutoCadastradoDTO bind(Produto produto){
        return new ProdutoCadastradoDTO(produto.getId(), produto.getIdCategoria(), produto.getNome(), produto.getValor());
    }

    public static List<ProdutoCadastradoDTO> listBind(List<Produto> produtos){
        return produtos.stream().map(ProdutoCadastradoDTO::new).toList();
    }
}
