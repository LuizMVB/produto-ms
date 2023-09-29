package br.com.microsservice.produtoms.service;

import br.com.microsservice.produtoms.domain.entity.Produto;
import br.com.microsservice.produtoms.dto.OfertaDTO;
import br.com.microsservice.produtoms.domain.entity.Oferta;
import br.com.microsservice.produtoms.repository.OfertaRepository;
import br.com.microsservice.produtoms.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CadastroOfertaService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private OfertaRepository ofertaRepository;

    @Transactional
    public OfertaDTO criar(Long idProduto, OfertaDTO ofertaDTO) {
        Produto produto = produtoRepository
                .findById(idProduto)
                .orElseThrow(EntityNotFoundException::new);
        Oferta oferta = modelMapper.map(ofertaDTO, Oferta.class);
        oferta.setProduto(produto);
        ofertaRepository.save(oferta);
        return modelMapper.map(oferta, OfertaDTO.class);
    }

    public Page<OfertaDTO> listar(Long idProduto, Pageable paginacao) {
        return ofertaRepository
                .findByIdProduto(idProduto, paginacao)
                .map(oferta -> modelMapper.map(oferta, OfertaDTO.class));
    }

    public OfertaDTO detalhar(Long id) {
        Oferta oferta = ofertaRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(oferta, OfertaDTO.class);
    }

    @Transactional
    public void substituir(Long id, OfertaDTO ofertaDTO) {
        ofertaDTO.setId(id);
        Oferta oferta = modelMapper.map(ofertaDTO, Oferta.class);
        ofertaRepository.save(oferta);
    }

    @Transactional
    public void modificar(Long id, OfertaDTO ofertaDTO) {
        Oferta oferta = ofertaRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        Oferta ofertaToBe = modelMapper.map(ofertaDTO, Oferta.class);
        oferta.mergeNonNullProperties(ofertaToBe);
        ofertaRepository.save(oferta);
    }

}
