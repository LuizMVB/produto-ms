package br.com.microsservice.produtoms.domain.listener;

import br.com.microsservice.produtoms.service.ControleAtivacaoOfertaService;
import br.com.microsservice.produtoms.domain.event.OnChangeIsAtivoProdutoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class OnChangeIsAtivoProdutoListener {

    @Autowired
    private ControleAtivacaoOfertaService controleAtivacaoOfertaService;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onChangeIsAtivoProduto(OnChangeIsAtivoProdutoEvent event) {
        if(event.getLastIsAtivo().equals(event.getIsAtivo())) {
            return;
        }

        if(event.getIsAtivo()) {
            return;
        }

        controleAtivacaoOfertaService.desativar(event.getId());
    }
}
