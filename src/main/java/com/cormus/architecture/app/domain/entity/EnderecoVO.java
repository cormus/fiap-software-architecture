package com.cormus.architecture.app.domain.entity;

import com.cormus.architecture.app.infra.common.dto.EnderecoDto;

public class EnderecoVO {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String uf;
    private String cidade;

    public EnderecoVO(EnderecoDto endereco) {
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }
}
