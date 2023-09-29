package br.com.microsservice.produtoms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OfertaDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String descricao;

    private Boolean isAtivo = true;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private LocalDateTime dataFim;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ProdutoDTO produto;
}
