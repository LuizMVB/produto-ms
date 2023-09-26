package br.com.microsservice.produtoms.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO {

    private Long id;

    @NotNull
    private String nome;

    private String descricao = null;

    private Boolean isAtivo = true;

    @NotNull
    private BigDecimal valorSugerido;

}
