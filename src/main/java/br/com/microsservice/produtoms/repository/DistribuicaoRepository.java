package br.com.microsservice.produtoms.repository;

import br.com.microsservice.produtoms.domain.TipoFilialEnum;
import br.com.microsservice.produtoms.domain.entity.Distribuicao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistribuicaoRepository extends JpaRepository<Distribuicao, Long> {
}

