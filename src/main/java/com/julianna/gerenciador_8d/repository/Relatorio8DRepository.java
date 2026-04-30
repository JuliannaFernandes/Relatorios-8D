package com.julianna.gerenciador_8d.repository;

import com.julianna.gerenciador_8d.entity.Relatorio8D;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface Relatorio8DRepository  extends JpaRepository<Relatorio8D, Long> {
    List<Relatorio8D> findByTituloContainingIgnoreCase(String titulo);
    List<Relatorio8D> findByTituloContainingIgnoreCase(String titulo, Pageable peageable);
    List<Relatorio8D> findByStatus(Relatorio8D.Status8D status);
    long countByStatus(Relatorio8D.Status8D status);
 }
