package br.com.microsservice.produtoms.service;

import br.com.microsservice.produtoms.domain.entity.Oferta;
import br.com.microsservice.produtoms.repository.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ControleAtivacaoOfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    public void desativar(Long idProduto) {
        var ofertaList = ofertaRepository
                .findByIdProduto(idProduto);

        if(CollectionUtils.isEmpty(ofertaList)) {
            return;
        }

        ofertaList.forEach(Oferta::desativar);

        ofertaRepository.saveAll(ofertaList);
    }
}
