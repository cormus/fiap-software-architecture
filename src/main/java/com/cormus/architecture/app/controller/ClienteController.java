package com.cormus.architecture.app.controller;

import com.cormus.architecture.app.infra.common.dto.ClienteCadastroDTO;
import com.cormus.architecture.app.infra.common.dto.ClienteIdentificacaoDTO;
import com.cormus.architecture.app.infra.common.dto.UsuarioDetalhamentoDto;
import com.cormus.architecture.app.infra.persistence.jpa.entity.Usuario;
import com.cormus.architecture.app.infra.persistence.jpa.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping(value = "api/v1/cliente")
public class ClienteController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/identificacao")
    @Transactional
    public ResponseEntity indentificacao(@RequestBody @Valid ClienteIdentificacaoDTO clienteIdentificacaoDTO){

        Usuario usuario = usuarioRepository.findByCpf(clienteIdentificacaoDTO.cpf());

        return ResponseEntity.ok(new UsuarioDetalhamentoDto(usuario));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ClienteCadastroDTO clienteCadastroDTO){

        Usuario usuario = new Usuario();
        usuario.setNome(clienteCadastroDTO.nome());
        usuario.setEmail(clienteCadastroDTO.email());
        usuario.setCpf(clienteCadastroDTO.cpf());
        usuarioRepository.save(usuario);

        return ResponseEntity.ok(new UsuarioDetalhamentoDto(usuario));
    }
}
