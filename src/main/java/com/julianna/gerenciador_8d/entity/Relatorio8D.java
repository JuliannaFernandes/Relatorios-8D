package com.julianna.gerenciador_8d.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity@Table(name = "relatorio_8d")
public class Relatorio8D {

 @Getter
 @Setter
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Setter
 @Getter
 @Column(nullable = false)
 private String titulo;

 @Column(nullable = false)
 private String cliente;

 @Getter
 @Column(nullable = false, length =2000)
 private String descricao;

 @Enumerated(EnumType.STRING)
 @Column(nullable = false)
 private Status8D status;

 @Column(nullable = false, updatable = false)
 private LocalDateTime dataCriacao;

 @PrePersist protected void onCreate() {
 this.dataCriacao = LocalDateTime.now();
 }

 public enum Status8D {
 ABERTO,
 FECHADO,
 PENDENTE }

}

