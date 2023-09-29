package br.com.microsservice.produtoms.service;

import br.com.microsservice.produtoms.domain.TipoFilialEnum;
import br.com.microsservice.produtoms.dto.ProdutoDTO;
import br.com.microsservice.produtoms.domain.entity.Produto;
import br.com.microsservice.produtoms.repository.ProdutoRepository;
import br.com.microsservice.produtoms.specification.ProdutoSpecification;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class CadastroProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoDTO criar(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto = produtoRepository.save(produto);
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public Page<ProdutoDTO> listar(String cidade, String uf, TipoFilialEnum tipoFilial, Pageable paginacao) {
        Specification<Produto> produtoSpecification = Specification
                .where(ProdutoSpecification.filtrarPorCidadeUfETipoFilial(cidade, uf, tipoFilial));
        return produtoRepository
                .findAll(produtoSpecification, paginacao)
                .map(produto -> modelMapper.map(produto, ProdutoDTO.class));
    }

    public ProdutoDTO detalhar(Long id) {
        Produto mercado = produtoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(mercado, ProdutoDTO.class);
    }

    @Transactional
    public void substituir(Long id, ProdutoDTO produtoDTO) {
        produtoDTO.setId(id);
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produtoRepository.save(produto);
    }

    @Transactional
    public void modificar(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        Produto produtoToBe = modelMapper.map(produtoDTO, Produto.class);
        produto.mergeNonNullProperties(produtoToBe);
        produtoRepository.save(produto);
    }
}
