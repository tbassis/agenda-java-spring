package com.example.agenda.dto;

import com.example.agenda.model.Contato;

public record ContatoResumoDTO(
        Integer id,
        String nome,
        String email,
        String celular,
        String favorito
) {
    public ContatoResumoDTO(Contato contato) {
        this(contato.getId(), contato.getNome(), contato.getEmail(), contato.getCelular(), contato.getFavorito());
    }
}
