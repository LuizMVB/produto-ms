package br.com.microsservice.produtoms.repository;

import br.com.microsservice.produtoms.domain.entity.Oferta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {

    @Query("SELECT o FROM Oferta o WHERE o.produto.id = :idProduto")
    Page<Oferta> findByIdProduto(Long idProduto, Pageable paginacao);

    @Query("SELECT o FROM Oferta o WHERE o.produto.id = :idProduto")
    List<Oferta> findByIdProduto(Long idProduto);

}
