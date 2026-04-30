package com.julianna.gerenciador_8d.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity@Table(name = "etapas")
@Getter
@Setter
public class Etapas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private tipoEtapa tipoEtapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relatorio_8d_id", nullable = false)
    private Relatorio8D relatorio8D;

    @OneToMany(mappedBy = "etapas", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Acao> acao = new java.util.ArrayList<>();

    public enum tipoEtapa {
        D1,
        D2,
        D3,
        D4,
        D5,
        D6,
        D7,
        D8
    }

}
