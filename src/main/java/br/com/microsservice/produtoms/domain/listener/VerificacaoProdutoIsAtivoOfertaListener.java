package br.com.microsservice.produtoms.domain.listener;

import br.com.microsservice.produtoms.domain.event.VerificacaoProdutoIsAtivoOfertaEvent;
import br.com.microsservice.produtoms.service.ControleAtivacaoProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class VerificacaoProdutoIsAtivoOfertaListener {

    @Autowired
    private ControleAtivacaoProdutoService controleAtivacaoProdutoService;
    
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onChangeIsAtivoOferta(VerificacaoProdutoIsAtivoOfertaEvent event) {
        Boolean produtoIsAtivo = controleAtivacaoProdutoService
                .isProdutoAtivo(event.getIdOferta());

        if(!produtoIsAtivo) {
            throw new RuntimeException("O produto está inativo: não é possível " +
                    "criar ou atualizar uma oferta de um produto desativado");
        }
    }
    
}
