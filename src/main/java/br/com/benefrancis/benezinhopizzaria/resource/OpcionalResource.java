package br.com.benefrancis.benezinhopizzaria.resource;

import br.com.benefrancis.benezinhopizzaria.dto.request.OpcionalRequest;
import br.com.benefrancis.benezinhopizzaria.dto.response.OpcionalResponse;
import br.com.benefrancis.benezinhopizzaria.entity.Opcional;
import br.com.benefrancis.benezinhopizzaria.service.OpcionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/opcional")
public class OpcionalResource {

    @Autowired
    OpcionalService service;

    @GetMapping
    public ResponseEntity<Collection<OpcionalResponse>> findAll(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "preco", required = false) BigDecimal preco
            ) {

        var opcional = Opcional.builder()
                .id( id )
                .nome( nome )
                .preco( preco )
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Opcional> example = Example.of( opcional, matcher );

        var encontrados = service.findAll( example );
        var resposta = encontrados.stream()
                .map( service::toResponse )
                .collect(Collectors.toList());

        return ResponseEntity.ok( resposta );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<OpcionalResponse> save(
            @RequestBody OpcionalRequest r
    ) {
        if (Objects.isNull( r )) return ResponseEntity.notFound().build();

        return ResponseEntity.ok( service.toResponse( service.toEntity( r ) ));
    }
}
