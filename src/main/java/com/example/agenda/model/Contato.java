package com.example.agenda.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "contato")
@Data
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contato_id")
    private Integer id;

    @Column(name = "contato_nome", nullable = false)
    private String nome;

    @Column(name = "contato_email", nullable = false)
    private String email;

    @Column(name = "contato_celular", nullable = false, length = 11)
    private String celular;

    @Column(name = "contato_telefone")
    private String telefone;

    @Column(name = "contato_sn_favorito", length = 1)
    private String favorito = "N";

    @Column(name = "contato_sn_ativo", length = 1)
    private String ativo = "S";

    @Column(name = "contato_dh_cad")
    private LocalDateTime dataAniversario;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
