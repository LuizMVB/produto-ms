package br.com.microsservice.produtoms.controller;

import br.com.microsservice.produtoms.controller.dto.ProdutoDTO;
import br.com.microsservice.produtoms.service.CadastroProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

    @Autowired
    private CadastroProdutoService cadastroProdutoService;

    @PostMapping(value = "/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO criar(@RequestBody @Valid ProdutoDTO produtoDTO) {
        return cadastroProdutoService.criar(produtoDTO);
    }

    @GetMapping(value = "/produto")
    public Page<ProdutoDTO> listar(@PageableDefault(size = 15) Pageable paginacao) {
        return cadastroProdutoService.listar(paginacao);
    }

    @GetMapping(value = "/produto/{id}")
    public ProdutoDTO detalhar(@PathVariable @NotNull Long id) {
        return cadastroProdutoService.detalhar(id);
    }

    @PutMapping(value = "/produto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void substituir(@PathVariable @NotNull Long id,
                          @RequestBody @Valid ProdutoDTO produtoDTO) {
        cadastroProdutoService.substituir(id, produtoDTO);
    }

    @PatchMapping(value = "/produto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modificar(@PathVariable @NotNull Long id,
                          @RequestBody ProdutoDTO produtoDTO) {
        cadastroProdutoService.modificar(id, produtoDTO);
    }

}
