package br.com.benefrancis.benezinhopizzaria.repository;

import br.com.benefrancis.benezinhopizzaria.entity.Opcional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionalRepository extends JpaRepository<Opcional, Long> {
}
