package com.cormus.architecture.app.domain.entity;

import com.cormus.architecture.app.infra.persistence.jpa.entity.EnderecoVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String senha;

    private EnderecoVO endereco;
}
