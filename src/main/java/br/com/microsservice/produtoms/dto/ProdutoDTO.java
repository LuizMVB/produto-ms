package br.com.microsservice.produtoms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private String nome;

    private String descricao;

    private Boolean isAtivo = true;

    @NotNull
    private BigDecimal valorSugerido;

}
