package com.example.agenda.repository;

import com.example.agenda.model.Contato;
import com.example.agenda.dto.ContatoResumoDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    List<Contato> findByAtivo(String ativo);

    @Transactional
    @Modifying
    @Query("UPDATE Contato c SET c.ativo = 'N' WHERE c.id = ?1")
    void desativar(Integer id);

    @Query("SELECT c FROM Contato c WHERE c.id = :id AND c.ativo = 'S'")
    Optional<Contato> findByIdAtivo(@Param("id") Integer id);

    @Query("SELECT new com.example.agenda.dto.ContatoResumoDTO(c.id, c.nome, c.favorito) FROM Contato c WHERE c.ativo = 'S'")
    List<ContatoResumoDTO> findResumoContatos();
}
