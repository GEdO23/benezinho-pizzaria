package br.com.benefrancis.benezinhopizzaria.repository;

import br.com.benefrancis.benezinhopizzaria.entity.Pizzaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzariaRepository extends JpaRepository<Pizzaria, Long> {
}
