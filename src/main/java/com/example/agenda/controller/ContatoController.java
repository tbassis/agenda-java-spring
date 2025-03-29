package com.example.agenda.controller;

import com.example.agenda.model.Contato;
import com.example.agenda.service.ContatoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private final ContatoService service;

    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contato> listar() {
        return service.listarContatos();
    }

    @PostMapping
    public Contato adicionar(@RequestBody Contato contato) {
        return service.adicionarContato(contato);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.removerContato(id);
    }
}
