package br.com.microsservice.produtoms.service;

import br.com.microsservice.produtoms.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControleAtivacaoProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Boolean isProdutoAtivo(Long idOferta) {
        var produto = produtoRepository
                .findByIdOferta(idOferta)
                .orElseThrow(EntityNotFoundException::new);

        return produto.getIsAtivo();
    }

}
