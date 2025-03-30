package com.example.agenda.repository;

import com.example.agenda.model.Contato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    List<Contato> findByAtivo(String ativo);

    @Transactional
    @Modifying
    @Query("UPDATE Contato c SET c.ativo = 'N' WHERE c.id = ?1")
    void desativar(Integer id);
}
