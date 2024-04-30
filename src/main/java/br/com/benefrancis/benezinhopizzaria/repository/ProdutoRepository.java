package br.com.benefrancis.benezinhopizzaria.repository;

import br.com.benefrancis.benezinhopizzaria.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
