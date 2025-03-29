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
    private Long contato_id;

    @Column(name = "contato_nome", nullable = false)
    private String contato_nome;

    @Column(name = "contato_email", nullable = false)
    private String contato_email;

    @Column(name = "contato_celular", nullable = false, length = 11)
    private String contato_celular;

    @Column(name = "contato_telefone")
    private String contato_telefone;

    @Column(name = "contato_sn_favorito", length = 1)
    private char contato_sn_favorito = 'N';

    @Column(name = "contato_sn_ativo", length = 1)
    private char contato_sn_ativo = 'S';

    @Column(name = "contato_dh_cad")
    private LocalDateTime dataCadastro;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}

//package com.example.agenda.model;
//
//import jakarta.persistence.*;
//
//
//@Entity
//@Table(name = "contato")
//public class Contato {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "contato_id")
//    private Long contato_id;
//
//    @Column(name = "contato_nome", nullable = false)
//    private String contato_nome;
//
//    @Column(name = "contato_email", nullable = false)
//    private String contato_email;
//
//    @Column(name = "contato_celular", nullable = false, length = 11)
//    private String contato_celular;
//
//    @Column(name = "contato_telefone", length = 10)
//    private String contato_telefone;
//
//    @Column(name = "contato_sn_favorito", length = 1)
//    private char contato_sn_favorito = 'N';
//
//    @Column(name = "contato_sn_ativo", length = 1)
//    private char contato_sn_ativo = 'S';
//}
