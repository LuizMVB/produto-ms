package br.com.microsservice.produtoms.controller;

import br.com.microsservice.produtoms.dto.OfertaDTO;
import br.com.microsservice.produtoms.service.CadastroOfertaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OfertaController {

    @Autowired
    private CadastroOfertaService cadastroOfertaService;

    @PostMapping(value = "/produto/{id}/oferta")
    @ResponseStatus(HttpStatus.CREATED)
    public OfertaDTO criar(@PathVariable @NotNull Long id,
                           @RequestBody @Valid OfertaDTO ofertaDTO) {
        return cadastroOfertaService.criar(id, ofertaDTO);
    }

    @GetMapping(value = "/produto/{id}/oferta")
    public Page<OfertaDTO> listar(@PathVariable @NotNull Long id,
                                  @PageableDefault(size = 15) Pageable paginacao) {
        return cadastroOfertaService.listar(id, paginacao);
    }

    @GetMapping(value = "/produto/oferta/{id}")
    public OfertaDTO detalhar(@PathVariable @NotNull Long id) {
        return cadastroOfertaService.detalhar(id);
    }

    @PutMapping(value = "/produto/oferta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void substituir(@PathVariable @NotNull Long id,
                           @RequestBody @Valid OfertaDTO ofertaDTO) {
        cadastroOfertaService.substituir(id, ofertaDTO);
    }

    @PatchMapping(value = "/produto/oferta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modificar(@PathVariable @NotNull Long id,
                          @RequestBody OfertaDTO ofertaDTO) {
        cadastroOfertaService.modificar(id, ofertaDTO);
    }

}