package com.example.agenda.dto;

import com.example.agenda.model.Contato;

public record ContatoResumoDTO(
        Integer id,
        String nome
) {
    public ContatoResumoDTO(Contato contato) {
        this(contato.getId(), contato.getNome());
    }
}
