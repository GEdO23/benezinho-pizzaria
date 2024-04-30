package br.com.benefrancis.benezinhopizzaria.resource;

import br.com.benefrancis.benezinhopizzaria.dto.request.OpcionalRequest;
import br.com.benefrancis.benezinhopizzaria.dto.request.PizzariaRequest;
import br.com.benefrancis.benezinhopizzaria.dto.response.OpcionalResponse;
import br.com.benefrancis.benezinhopizzaria.dto.response.PizzariaResponse;
import br.com.benefrancis.benezinhopizzaria.entity.Pizzaria;
import br.com.benefrancis.benezinhopizzaria.entity.Produto;
import br.com.benefrancis.benezinhopizzaria.service.PizzariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pizzaria")
public class PizzariaResource {

    @Autowired
    PizzariaService service;

    @GetMapping
    public ResponseEntity<Collection<PizzariaResponse>> findAll(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "nome", required = false) String nome
    ) {
        var cardapio = service.findById(id).getCardapio();

        var pizzaria = Pizzaria.builder()
                .id( id )
                .nome( nome )
                .cardapio( cardapio )
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Pizzaria> example = Example.of( pizzaria, matcher );

        var encontrados = service.findAll( example );
        var resposta = encontrados.stream()
                .map( service::toResponse )
                .collect(Collectors.toList());

        return ResponseEntity.ok( resposta );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PizzariaResponse> save(
            @RequestBody PizzariaRequest r
    ) {
        if (Objects.isNull( r )) return ResponseEntity.notFound().build();

        return ResponseEntity.ok( service.toResponse( service.toEntity( r ) ));
    }
}
