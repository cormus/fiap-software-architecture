//package com.cormus.architecture.app.controller;
//
//import com.cormus.architecture.app.infra.common.dto.AutenticacaoDto;
//import com.cormus.architecture.app.infra.persistence.jpa.entity.UsuarioEntity;
//import com.cormus.architecture.app.infra.security.AutenticacaoTokenDto;
//import com.cormus.architecture.app.infra.security.SecurityTokenService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/login")
//public class AutenticacaoController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private SecurityTokenService securityTokenService;
//
//    @PostMapping
//    public ResponseEntity logar(@RequestBody @Valid AutenticacaoDto autenticacao){
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(autenticacao.login(), autenticacao.senha());
//        Authentication autentication = authenticationManager.authenticate(authenticationToken);
//
//        String jwtToken = securityTokenService.gerarToken((UsuarioEntity) autentication.getPrincipal());
//
//        return ResponseEntity.ok(new AutenticacaoTokenDto(jwtToken));
//    }
//
//}
