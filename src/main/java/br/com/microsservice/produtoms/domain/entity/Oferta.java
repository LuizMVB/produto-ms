package br.com.microsservice.produtoms.domain.entity;

import br.com.microsservice.produtoms.domain.event.VerificacaoProdutoIsAtivoOfertaEvent;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class Oferta extends AbstractAggregateRoot<Oferta> {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto", updatable = false)
    private Produto produto;

    @OneToMany(mappedBy = "oferta", cascade = CascadeType.ALL)
    private List<Distribuicao> distribuicaoList;

    public Oferta() {
        registerEvent(new VerificacaoProdutoIsAtivoOfertaEvent(id));
    }

    public void desativar() {
        isAtivo = false;
    }
}
