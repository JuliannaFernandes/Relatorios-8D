package com.julianna.gerenciador_8d.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity @Table (name = "evidencias")
@Getter
@Setter
public class Evidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2000)
    private String descricao;

    @Column(nullable = false)
    private TipoArquivo tipoArquivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acao_id", nullable = false)
    private Acao acao;

    public enum TipoArquivo {
        DOCUMENTO,
        IMAGEM,
        VIDEO,
        EXCEL,
        WORD,
        PDF,
        OUTRO
    }
}
