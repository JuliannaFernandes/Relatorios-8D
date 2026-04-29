package com.julianna.gerenciador_8d.entity;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDateTime;

    @Entity
    @Table(name = "acoes")
    @Getter
    @Setter
    public class Acao {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 2000)
        private String descricao;

        @Column(nullable = false)
        private LocalDateTime dataPrazo;

        @Column(nullable = false)
        private TipoArquivo tipoArquivo;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "etapa_8d_id", nullable = false)
        private Etapas etapa8D;

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