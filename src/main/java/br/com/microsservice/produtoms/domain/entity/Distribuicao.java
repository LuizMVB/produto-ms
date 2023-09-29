package br.com.microsservice.produtoms.domain.entity;

import br.com.microsservice.produtoms.domain.TipoFilialEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Distribuicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2, nullable = false)
    private String uf;

    @Column(length = 20, nullable = false)
    private String cidade;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoFilialEnum tipoFilial;

    @ManyToOne
    @JoinColumn(name = "id_oferta")
    private Oferta oferta;

}
