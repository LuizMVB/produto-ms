package br.com.microsservice.produtoms.domain.entity;

import jakarta.persistence.*;

@Entity
@Table
public class PlanoParcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
