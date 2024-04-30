package br.com.benefrancis.benezinhopizzaria.repository;

import br.com.benefrancis.benezinhopizzaria.entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {
}
