package br.com.benefrancis.benezinhopizzaria.service;

import br.com.benefrancis.benezinhopizzaria.dto.request.OpcionalRequest;
import br.com.benefrancis.benezinhopizzaria.dto.response.OpcionalResponse;
import br.com.benefrancis.benezinhopizzaria.entity.Opcional;
import br.com.benefrancis.benezinhopizzaria.repository.OpcionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OpcionalService implements ServiceDTO<Opcional, OpcionalRequest, OpcionalResponse> {

    @Autowired
    OpcionalRepository repo;

    @Override
    public Opcional toEntity(OpcionalRequest r) {
        return Opcional.builder()
                .nome(r.nome())
                .preco(r.preco())
                .build();
    }

    @Override
    public OpcionalResponse toResponse(Opcional e) {
        if (Objects.isNull( e )) return null;

        return new OpcionalResponse(
                e.getId(),
                e.getNome(),
                e.getPreco()
        );
    }

    @Override
    public List<Opcional> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Opcional> findAll(Example<Opcional> example) {
        return repo.findAll( example );
    }

    @Override
    public Opcional findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Opcional save(OpcionalRequest r) {
        if (Objects.isNull( r )) return null;
        return repo.save( toEntity(r) );
    }
}
