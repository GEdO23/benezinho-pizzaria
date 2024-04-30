package br.com.benefrancis.benezinhopizzaria.resource;

import br.com.benefrancis.benezinhopizzaria.dto.request.ProdutoRequest;
import br.com.benefrancis.benezinhopizzaria.dto.request.SaborRequest;
import br.com.benefrancis.benezinhopizzaria.dto.response.ProdutoResponse;
import br.com.benefrancis.benezinhopizzaria.dto.response.SaborResponse;
import br.com.benefrancis.benezinhopizzaria.entity.Sabor;
import br.com.benefrancis.benezinhopizzaria.service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sabor")
public class SaborResource {

    @Autowired
    SaborService service;

    @GetMapping
    public ResponseEntity<Collection<SaborResponse>> findAll(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "nome", required = false) String nome
    ) {
        var descricao = service.findById(id).getDescricao();

        var sabor = Sabor.builder()
                .id( id )
                .nome( nome )
                .descricao( descricao )
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Sabor> example = Example.of( sabor, matcher );

        var encontrados = service.findAll( example );
        var resposta = encontrados.stream()
                .map( service::toResponse )
                .collect(Collectors.toList());

        return ResponseEntity.ok( resposta );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<SaborResponse> save(
            @RequestBody SaborRequest r
    ) {
        if (Objects.isNull( r )) return ResponseEntity.notFound().build();

        return ResponseEntity.ok( service.toResponse( service.toEntity( r ) ));
    }
}
