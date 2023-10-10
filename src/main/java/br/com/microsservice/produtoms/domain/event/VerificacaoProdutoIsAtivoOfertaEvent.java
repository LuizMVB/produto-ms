package br.com.microsservice.produtoms.domain.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class VerificacaoProdutoIsAtivoOfertaEvent {

    private final Long idOferta;

}
