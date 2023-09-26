package br.com.microsservice.produtoms.service;

import br.com.microsservice.produtoms.controller.dto.ProdutoDTO;
import br.com.microsservice.produtoms.domain.entity.Produto;
import br.com.microsservice.produtoms.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class CadastroProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoDTO criar(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto = produtoRepository.save(produto);
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public Page<ProdutoDTO> listar(@PageableDefault(size = 15) Pageable paginacao) {
        return produtoRepository
                .findAll(paginacao)
                .map(mercado -> modelMapper.map(mercado, ProdutoDTO.class));
    }

    public ProdutoDTO detalhar(Long id) {
        Produto mercado = produtoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(mercado, ProdutoDTO.class);
    }

    public void substituir(Long id, ProdutoDTO produtoDTO) {
        produtoDTO.setId(id);
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produtoRepository.save(produto);
    }

    public void modificar(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        Produto produtoToBe = modelMapper.map(produtoDTO, Produto.class);
        produto.mergeNonNullProperties(produtoToBe);
        produtoRepository.save(produto);
    }
}
