package com.example.agenda.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contato_id;

    @Column(nullable = false)
    private String contato_nome;

    @Column(nullable = false)
    private String contato_email;

    @Column(nullable = false)
    private String contato_celular;

    private String contato_telefone = "";

    private char contato_sn_favorito = 'N';

    private char contato_sn_ativo = 'S';
}
