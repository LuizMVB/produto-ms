package br.com.microsservice.produtoms.repository;

import br.com.microsservice.produtoms.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
