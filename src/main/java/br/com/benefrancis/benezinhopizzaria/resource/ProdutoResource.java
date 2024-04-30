package br.com.benefrancis.benezinhopizzaria.resource;

import br.com.benefrancis.benezinhopizzaria.dto.request.PizzariaRequest;
import br.com.benefrancis.benezinhopizzaria.dto.request.ProdutoRequest;
import br.com.benefrancis.benezinhopizzaria.dto.response.PizzariaResponse;
import br.com.benefrancis.benezinhopizzaria.dto.response.ProdutoResponse;
import br.com.benefrancis.benezinhopizzaria.entity.Opcional;
import br.com.benefrancis.benezinhopizzaria.entity.Produto;
import br.com.benefrancis.benezinhopizzaria.entity.Sabor;
import br.com.benefrancis.benezinhopizzaria.service.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoResource {
    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<Collection<ProdutoResponse>> findAll(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "preco", required = false) BigDecimal preco,
            @RequestParam(name = "sabor", required = false) Sabor sabor
            ) {

        var opcionais = service.findById(id).getOpcionais();

        var produto = Produto.builder()
                .id( id )
                .nome( nome )
                .preco( preco )
                .sabor( sabor )
                .opcionais( opcionais )
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Produto> example = Example.of( produto, matcher );

        var encontrados = service.findAll( example );
        var resposta = encontrados.stream()
                .map( service::toResponse )
                .collect(Collectors.toList());

        return ResponseEntity.ok( resposta );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> save(
            @RequestBody ProdutoRequest r
    ) {
        if (Objects.isNull( r )) return ResponseEntity.notFound().build();

        return ResponseEntity.ok( service.toResponse( service.toEntity( r ) ));
    }
}
