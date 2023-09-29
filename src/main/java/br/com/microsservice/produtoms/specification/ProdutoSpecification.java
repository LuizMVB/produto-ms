package br.com.microsservice.produtoms.specification;

import br.com.microsservice.produtoms.domain.TipoFilialEnum;
import br.com.microsservice.produtoms.domain.entity.Distribuicao;
import br.com.microsservice.produtoms.domain.entity.Oferta;
import br.com.microsservice.produtoms.domain.entity.Produto;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ProdutoSpecification {

    public static Specification<Produto> filtrarPorCidadeUfETipoFilial(String cidade, String uf, TipoFilialEnum tipoFilial) {
        return (root, query, cb) -> {
            if (cidade == null && uf == null && tipoFilial == null) return null;

            Join<Produto, Oferta> joinOferta = root.join("ofertaList");
            Join<Oferta, Distribuicao> joinDistribuicao = joinOferta.join("distribuicaoList");

            List<Predicate> predicates = new ArrayList<>();

            if (cidade != null) {
                predicates.add(cb.equal(joinDistribuicao.get("cidade"), cidade));
            }

            if (uf != null) {
                predicates.add(cb.equal(joinDistribuicao.get("uf"), uf));
            }

            if (tipoFilial != null) {
                predicates.add(cb.equal(joinDistribuicao.get("tipoFilial"), tipoFilial));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
