package com.cormus.architecture.app.infra.persistence.jpa.datasource;

import com.cormus.architecture.app.domain.entity.Pedido;
import com.cormus.architecture.app.domain.entity.ProdutoCategoria;
import com.cormus.architecture.app.infra.common.converter.ProdutoCategoriaConverter;
import com.cormus.architecture.app.infra.persistence.jpa.entity.ProdutoCategoriaEntity;
import com.cormus.architecture.app.infra.persistence.jpa.repository.ProdutoCategoriaRepository;
import com.cormus.architecture.app.infra.rest.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProdutoCategoriaDataSource implements com.cormus.architecture.app.domain.common.interfaces.datasource.ProdutoCategoriaDataSource {

    @Autowired
    ProdutoCategoriaRepository produtoCategoriaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${categoria.service.url}")
    private String categoriaServiceUrl;

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

//    public ProdutoCategoria recuperarProdutoCategoriaPorId(Long idCategoria) {
//        RestClient client = new RestClient();
//
//        ProdutoCategoria post = null;
//        try {
//            String json = client.get(this.categoriaServiceUrl + "/categoria/" + idCategoria.toString());
//            if(!json.isEmpty()){
//                post = objectMapper.readValue(json, ProdutoCategoria.class);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return post;
//    }
}
