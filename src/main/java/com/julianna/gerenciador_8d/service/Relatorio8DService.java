package com.julianna.gerenciador_8d.service;

import com.julianna.gerenciador_8d.entity.Relatorio8D;
import com.julianna.gerenciador_8d.repository.Relatorio8DRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Relatorio8DService {
    private final Relatorio8DRepository repository;

    public Relatorio8DService(Relatorio8DRepository repository){
        this.repository = repository;
    }

    public List<Relatorio8D> findAll(){
        return repository.findAll();
    }


    public Optional<Relatorio8D> findById(Long id) {
        return repository.findById(id);
    }

    public List<Relatorio8D> findByTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Relatorio8D> findByStatus(Relatorio8D.Status8D status) {
        if (status == null){
            throw new IllegalArgumentException("O status não pode ser nulo.");
        }
        return repository.findByStatus(status);
    }

    public long countByStatus(Relatorio8D.Status8D status) {
        if (status == null){
            throw new IllegalArgumentException("O status não pode ser nulo.");
        }
        return repository.countByStatus(status);
    }

    public Relatorio8D save(Relatorio8D relatorio) {
        if (relatorio == null) {
            throw new IllegalArgumentException("Relatório não pode ser nulo");
        }
        if (relatorio.getTitulo() == null || relatorio.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode estar vazio");
        }
        if (relatorio.getStatus() == null) {
            throw new IllegalArgumentException("Status não pode ser nulo");
        }

        return repository.save(relatorio);
    }

    public void deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero");
        }
        repository.deleteById(id);
    }
}
