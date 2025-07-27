package com.cormus.architecture;

import com.cormus.architecture.app.controller.ProdutoCategoriaRestController;
import com.cormus.architecture.app.controller.ProdutoRestController;
import com.cormus.architecture.app.domain.adapters.gateway.ProdutoCategoriaGateway;
import com.cormus.architecture.app.domain.adapters.gateway.ProdutoGateway;
import com.cormus.architecture.app.domain.common.dto.ProdutoCadastradoDTO;
import com.cormus.architecture.app.domain.entity.Produto;
import com.cormus.architecture.app.domain.entity.ProdutoCategoria;
import com.cormus.architecture.app.infra.common.dto.PedidoAtualizarStatusRequest;
import com.cormus.architecture.app.infra.common.dto.ProdutoAtualizacaoRequest;
import com.cormus.architecture.app.infra.common.dto.ProdutoCadastroRequest;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.ProdutoCategoriaDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.datasource.ProdutoDataSource;
import com.cormus.architecture.app.infra.persistence.jpa.entity.PedidoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ProdutoRestControllerTest {

    @Mock
    ProdutoDataSource dataSource;

    @InjectMocks
    private ProdutoGateway gateway;

    @InjectMocks
    private ProdutoRestController controller;

    @BeforeEach
    void setup() {

        Produto produto1 = new Produto(1L);
        produto1.setIdCategoria(1L);
        produto1.setNome("Produto 1");
        produto1.setValor(150.0);

        Produto produto2 = new Produto(2L);
        produto2.setIdCategoria(2L);
        produto2.setNome("Produto 2");
        produto2.setValor(160.0);

        List<Produto> produtos = Arrays.asList(produto1, produto2);


        when(dataSource.cadastrar(any())).thenReturn(produto1);
        when(dataSource.listar()).thenReturn(produtos);
        when(dataSource.atualizar(any())).thenReturn(produto1);
        when(dataSource.recuperarProdutoPorId(anyLong())).thenReturn(produto1);
        doNothing().when(dataSource).excluir(anyLong());
    }

    @Test
    void testCadastrar() {

        ProdutoCadastroRequest produtoCadastroRequest = mock(ProdutoCadastroRequest.class);;
        UriComponentsBuilder uriBuilder = mock(UriComponentsBuilder.class);

        when(produtoCadastroRequest.idCategoria()).thenReturn(1L);
        when(produtoCadastroRequest.nome()).thenReturn("Produto Teste");
        when(produtoCadastroRequest.valor()).thenReturn(100.0);

        ResponseEntity result = controller.cadastrar(produtoCadastroRequest, uriBuilder);

        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void testAtualizar() {

        ProdutoAtualizacaoRequest produtoAtualizacaoRequest = mock(ProdutoAtualizacaoRequest.class);;

        when(produtoAtualizacaoRequest.id()).thenReturn(1L);
        when(produtoAtualizacaoRequest.idCategoria()).thenReturn(1L);
        when(produtoAtualizacaoRequest.nome()).thenReturn("Produto Teste");
        when(produtoAtualizacaoRequest.valor()).thenReturn(100.0);

        ResponseEntity result = controller.atualizar(produtoAtualizacaoRequest);

        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void testListar() {

        ResponseEntity<List<ProdutoCadastradoDTO>> result = controller.listar();

        assertEquals(2, result.getBody().size());
    }

    @Test
    void testDetalhar() {
        ResponseEntity result = controller.detalhar(1L);

        assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    void testExcluir() {
        ResponseEntity result = controller.excluir(1L);

        assertEquals(204, result.getStatusCodeValue());
    }

}

