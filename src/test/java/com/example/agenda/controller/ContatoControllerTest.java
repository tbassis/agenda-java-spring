package com.example.agenda.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.Collections;

import com.example.agenda.model.Contato;
import com.example.agenda.service.ContatoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ContatoController.class)
class ContatoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContatoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Contato contato;

    @BeforeEach
    void setUp() {
        contato = new Contato();
        contato.setNome("Teste");
        contato.setEmail("teste@email.com");
        contato.setCelular("81999556633");
        contato.setFavorito("N");
        contato.setAtivo("S");
    }

//    @Test
//    void deveAdicionarNovoContato() {
//    }

//    @Test
//    void deveAtualizarContatoExistente() {
//    }

//    @Test
//    void deveDesativarContato() {
//    }

//    @Test
//    void deveListarApenasContatosAtivos() {
//    }


//    @Test
//    void deveBuscarContatoAtivoPorId() {
//    }
}