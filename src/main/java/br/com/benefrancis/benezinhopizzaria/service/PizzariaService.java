package br.com.benefrancis.benezinhopizzaria.service;

import br.com.benefrancis.benezinhopizzaria.dto.request.PizzariaRequest;
import br.com.benefrancis.benezinhopizzaria.dto.response.PizzariaResponse;
import br.com.benefrancis.benezinhopizzaria.entity.Pizzaria;
import br.com.benefrancis.benezinhopizzaria.repository.PizzariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PizzariaService implements ServiceDTO<Pizzaria, PizzariaRequest, PizzariaResponse> {

    @Autowired
    PizzariaRepository repo;

    @Override
    public Pizzaria toEntity(PizzariaRequest r) {
        return Pizzaria.builder()
                .nome(r.nome())
                .cardapio(r.cardapio())
                .build();
    }

    @Override
    public PizzariaResponse toResponse(Pizzaria e) {
        if (Objects.isNull( e )) return null;

        return new PizzariaResponse(
                e.getId(),
                e.getNome(),
                e.getCardapio()
        );
    }

    @Override
    public List<Pizzaria> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Pizzaria> findAll(Example<Pizzaria> example) {
        return repo.findAll( example );
    }

    @Override
    public Pizzaria findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Pizzaria save(PizzariaRequest r) {
        if (Objects.isNull( r )) return null;
        return repo.save(toEntity(r));
    }
}
