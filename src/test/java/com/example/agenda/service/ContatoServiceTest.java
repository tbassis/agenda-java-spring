package com.example.agenda.service;

import com.example.agenda.model.Contato;
import com.example.agenda.repository.ContatoRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContatoServiceTest {

    @Mock
    private ContatoRepository repository;

    @InjectMocks
    private ContatoService service;

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

    @Test
    void deveAdicionarNovoContato() {
        when(repository.save(any(Contato.class))).thenReturn(contato);

        Contato result = service.adicionarContato(contato);

        assertNotNull(result);
        assertEquals("Teste", result.getNome());
        assertEquals("teste@email.com", result.getEmail());
        assertEquals("81999556633", result.getCelular());
        assertEquals("N", result.getFavorito());
        assertEquals("S", result.getAtivo());
    }

    @Test
    void deveAtualizarContatoExistente() {
        when(repository.save(any(Contato.class))).thenReturn(contato);

        String newEmail = "updated@email.com";
        contato.setEmail(newEmail);

        Contato result = service.atualizar( contato);

        assertEquals(newEmail, result.getEmail());
    }

    @Test
    void deveDesativarContato() {
        Integer id = 1;

        service.removerContato(id);

        verify(repository).desativar(id);
    }


//    @Test
//    void deveRetornarUsuarioPeloId() {
//        when(repository.findByIdAtivo(Integer).thenReturn(contato);
//
//        Contato result = service.getContatoById(1);
//
//        assertNotNull(result);
//        assertEquals(1, result.getId());
//        assertEquals("Teste", result.getNome());
//        assertEquals("teste@email.com", result.getEmail());
//        assertEquals("81999556633", result.getCelular());
//        assertEquals("N", result.getFavorito());
//        assertEquals("S", result.getAtivo());
//    }

//    @Test
//    void deveDesativarContato() {
//        when(repository.findById(1)).thenReturn(Optional.of(contato));
//
//        service.removerContato(1);
//
//        verify(repository).save(contato);
//        assertEquals("N", contato.getAtivo());
//    }
}