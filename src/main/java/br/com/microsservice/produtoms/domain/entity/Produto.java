package br.com.microsservice.produtoms.domain.entity;

import br.com.microsservice.produtoms.domain.Entidade;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Data
public class Produto extends Entidade<Produto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String nome;

    @Column(length = 50)
    private String descricao;

    @Column
    private Boolean isAtivo;

    @Column(precision = 8, scale = 2)
    private BigDecimal valorSugerido;

    @Embedded
    private DataEmbeddable data = new DataEmbeddable();

    @OneToMany(mappedBy = "produto")
    private List<Oferta> ofertaList;

    @PrePersist
    @PreUpdate
    public void onPrePersist() {
        if(isAtivo) {
            return;
        }

        if(CollectionUtils.isEmpty(ofertaList)) {
            return;
        }

        ofertaList.forEach(Oferta::desativar);
    }

}
