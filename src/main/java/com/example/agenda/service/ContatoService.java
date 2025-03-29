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

    public List<Contato> listarContatos() {
        return repository.findAll();
    }

    public Contato adicionarContato(Contato contato) {
        return repository.save(contato);
    }

    public void removerContato(Long id) {
        repository.deleteById(id);
    }
}