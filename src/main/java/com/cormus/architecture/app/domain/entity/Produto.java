package com.cormus.architecture.app.domain.entity;

import com.cormus.architecture.app.domain.dto.ProdutoAtualizacaoDTO;
import com.cormus.architecture.app.domain.dto.ProdutoCadastroDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "produto")
@Entity(name = "Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_categoria")
    private Long idCategoria;

    private String nome;

    private Double valor;

    @JsonManagedReference
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoImagem> imagens = new ArrayList<>();

    public Produto(ProdutoCadastroDTO produto){

        this.nome = produto.nome();
        this.valor = produto.valor();
        this.idCategoria = produto.idCategoria();

    }

    public Produto(ProdutoAtualizacaoDTO produto) {
        this.id = produto.id();
        this.nome = produto.nome();
        this.valor = produto.valor();
    }

    public Produto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
    }

    public void atualizar(ProdutoAtualizacaoDTO produtoDTO){
        this.nome = produtoDTO.nome();
        this.valor = produtoDTO.valor();
    }

    public void addImagem(ProdutoImagem item) {
        item.setProduto(this);
        this.imagens.add(item);
    }

    public void removeImagem(ProdutoImagem imagem) {
        imagens.remove(imagem);
        imagem.setProduto(null);
    }
}
