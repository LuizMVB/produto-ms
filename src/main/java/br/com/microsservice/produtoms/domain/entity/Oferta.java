package br.com.microsservice.produtoms.domain.entity;

import br.com.microsservice.produtoms.domain.Entidade;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
    private DataEmbeddable data = new DataEmbeddable();

    @ManyToOne
    @JoinColumn(name = "id_produto", updatable = false)
    private Produto produto;

    @OneToMany(mappedBy = "oferta", cascade = CascadeType.ALL)
    private List<Distribuicao> distribuicaoList;

    public void desativar() {
        isAtivo = false;
    }
}
