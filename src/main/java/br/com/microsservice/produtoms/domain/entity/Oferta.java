package br.com.microsservice.produtoms.domain.entity;

import br.com.microsservice.produtoms.domain.Entidade;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class Oferta extends Entidade<Oferta> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String nome;

    @Column(length = 50)
    private String descricao;

    @Column
    private Boolean isAtivo = true;

    @Column(precision = 8, scale = 2)
    private BigDecimal valor;

    @Column
    private LocalDateTime dataFim;

    @Embedded
    protected DataEmbeddable dataEmbeddable;

    @Column(nullable = false, updatable = false)
    private Long idFilial;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public void desativar() {
        isAtivo = false;
    }
}
