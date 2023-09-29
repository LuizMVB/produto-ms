package br.com.microsservice.produtoms.controller;

import br.com.microsservice.produtoms.domain.TipoFilialEnum;
import br.com.microsservice.produtoms.dto.DistribuicaoDTO;
import br.com.microsservice.produtoms.dto.FilialDTO;
import br.com.microsservice.produtoms.service.CadastroDistribuicaoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DistribuicaoController {

    @Autowired
    private CadastroDistribuicaoService cadastroDistribuicaoService;

    @PostMapping("/produto/oferta/{id}/distribuicao")
    @ResponseStatus(HttpStatus.CREATED)
    public DistribuicaoDTO criar(@PathVariable @NotNull Long id,
                                 @RequestBody @Valid DistribuicaoDTO distribuicaoDTO) {
        return cadastroDistribuicaoService.criar(id, distribuicaoDTO);
    }

}
