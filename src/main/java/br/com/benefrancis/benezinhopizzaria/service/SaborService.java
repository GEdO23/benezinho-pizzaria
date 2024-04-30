package br.com.benefrancis.benezinhopizzaria.service;

import br.com.benefrancis.benezinhopizzaria.dto.request.SaborRequest;
import br.com.benefrancis.benezinhopizzaria.dto.response.SaborResponse;
import br.com.benefrancis.benezinhopizzaria.entity.Sabor;
import br.com.benefrancis.benezinhopizzaria.repository.SaborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SaborService implements ServiceDTO<Sabor, SaborRequest, SaborResponse> {

    @Autowired
    SaborRepository repo;

    @Override
    public Sabor toEntity(SaborRequest r) {
        return Sabor.builder()
                .nome(r.nome())
                .descricao(r.descricao())
                .build();
    }

    @Override
    public SaborResponse toResponse(Sabor e) {
        if (Objects.isNull( e )) return null;

        return new SaborResponse(
                e.getId(),
                e.getNome(),
                e.getDescricao()
        );
    }

    @Override
    public List<Sabor> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Sabor> findAll(Example<Sabor> example) {
        return repo.findAll( example );
    }

    @Override
    public Sabor findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Sabor save(SaborRequest r) {
        if (Objects.isNull( r )) return null;
        return repo.save( toEntity(r) );
    }
}
