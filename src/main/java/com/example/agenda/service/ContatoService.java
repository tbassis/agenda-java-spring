package com.example.agenda.service;

import com.example.agenda.model.Contato;
import com.example.agenda.repository.ContatoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContatoService {
    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public List<Contato> listarAtivos() {
        return repository.findByAtivo("S");
    }

    public Contato adicionarContato(Contato contato) {
        return repository.save(contato);
    }

    public Contato atualizar(Integer id, Contato contato) {
        contato.setId(id);
        return repository.save(contato);
    }

    public void removerContato(Integer id) {
        Contato contato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        contato.setAtivo("N");
        repository.save(contato);
    }
}