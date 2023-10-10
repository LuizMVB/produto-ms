package br.com.microsservice.produtoms.repository;

import br.com.microsservice.produtoms.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

    @Query("SELECT p FROM Produto p " +
            "INNER JOIN p.ofertaList o " +
            "WHERE o.id = :idOferta")
    Optional<Produto> findByIdOferta(@Param("idOferta") Long idOferta);

}
