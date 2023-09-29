package br.com.microsservice.produtoms.dto;

import br.com.microsservice.produtoms.domain.TipoFilialEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DistribuicaoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    @NotEmpty
    private String uf;

    @NotNull
    @NotEmpty
    private String cidade;

    @NotNull
    @NotEmpty
    private TipoFilialEnum tipoFilial;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OfertaDTO oferta;

    public DistribuicaoDTO(String uf, String cidade, TipoFilialEnum tipoFilial) {
        this.uf = uf;
        this.cidade = cidade;
        this.tipoFilial = tipoFilial;
    }
}
