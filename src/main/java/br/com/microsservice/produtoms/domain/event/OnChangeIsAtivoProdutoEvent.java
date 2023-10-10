package br.com.microsservice.produtoms.domain.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OnChangeIsAtivoProdutoEvent {

    private final Long id;
    private final Boolean isAtivo;
    private final Boolean lastIsAtivo;

}
