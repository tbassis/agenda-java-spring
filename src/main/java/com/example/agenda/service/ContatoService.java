package com.example.agenda.service;

import com.example.agenda.model.Contato;
import com.example.agenda.dto.ContatoResumoDTO;
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

    public List<ContatoResumoDTO> listarAtivosResumo() {
        return repository.findByAtivoDto();
    }

    public Contato getContatoById(Integer id) {
        return repository.findByIdAtivo(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    public Contato adicionarContato(Contato contato) {
        return repository.save(contato);
    }

    public Contato atualizar(Contato contato) {
//        contato.setId(id);
        return repository.save(contato);
    }

    public void removerContato(Integer id) {
        repository.desativar(id);
    }
}