package br.com.microsservice.produtoms.dto;

import br.com.microsservice.produtoms.domain.TipoFilialEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilialDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private TipoFilialEnum tipo;

    @Valid
    @NotNull
    private EnderecoDTO endereco;

}
