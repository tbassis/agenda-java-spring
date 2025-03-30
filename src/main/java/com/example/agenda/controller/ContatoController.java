package com.example.agenda.controller;

import com.example.agenda.model.Contato;
import com.example.agenda.dto.ContatoResumoDTO;
import com.example.agenda.service.ContatoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    private final ContatoService service;

    @Autowired
    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarAtivos() {
        return ResponseEntity.ok(service.listarAtivos());
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<ContatoResumoDTO>> listarResumo() {
        return ResponseEntity.ok(service.listarResumoContatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> contatoId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getContatoId(id));
    }

    @PostMapping
    public Contato adicionar(@RequestBody Contato contato) {
        return service.adicionarContato(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(@PathVariable Integer id, @RequestBody Contato contato) {
        return ResponseEntity.ok(service.atualizar(id, contato));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.removerContato(id);
    }
}
