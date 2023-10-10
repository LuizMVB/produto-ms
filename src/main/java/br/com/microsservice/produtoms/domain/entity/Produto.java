package br.com.microsservice.produtoms.domain.entity;

import br.com.microsservice.produtoms.domain.event.OnChangeIsAtivoProdutoEvent;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class Produto extends AbstractAggregateRoot<Produto> {

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
    private BigDecimal valorSugerido;

    @Embedded
    private DataEmbeddable data = new DataEmbeddable();

    @OneToMany(mappedBy = "produto")
    private List<Oferta> ofertaList;

    @Transient
    private Boolean lastIsAtivo;

    public void setAtivo(Boolean ativo) {
        lastIsAtivo = isAtivo;
        isAtivo = ativo;
        registerEvent(new OnChangeIsAtivoProdutoEvent(id, isAtivo, lastIsAtivo));
    }
}
