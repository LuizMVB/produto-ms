package br.com.microsservice.produtoms.service;

import br.com.microsservice.produtoms.domain.entity.Distribuicao;
import br.com.microsservice.produtoms.domain.entity.Oferta;
import br.com.microsservice.produtoms.dto.DistribuicaoDTO;
import br.com.microsservice.produtoms.repository.DistribuicaoRepository;
import br.com.microsservice.produtoms.repository.OfertaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CadastroDistribuicaoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private DistribuicaoRepository distribuicaoRepository;

    @Transactional
    public DistribuicaoDTO criar(Long idOferta, DistribuicaoDTO distribuicaoDTO) {
        Oferta oferta = ofertaRepository
                .findById(idOferta)
                .orElseThrow(EntityNotFoundException::new);
        Distribuicao distribuicao = modelMapper.map(distribuicaoDTO, Distribuicao.class);
        distribuicao.setOferta(oferta);
        distribuicao = distribuicaoRepository.save(distribuicao);
        return modelMapper.map(distribuicao, DistribuicaoDTO.class);
    }

}
