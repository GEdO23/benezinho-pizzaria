package br.com.benefrancis.benezinhopizzaria.service;

import br.com.benefrancis.benezinhopizzaria.dto.request.ProdutoRequest;
import br.com.benefrancis.benezinhopizzaria.dto.response.ProdutoResponse;
import br.com.benefrancis.benezinhopizzaria.entity.Produto;
import br.com.benefrancis.benezinhopizzaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse> {

    @Autowired
    ProdutoRepository repo;

    @Override
    public Produto toEntity(ProdutoRequest r) {
        return Produto.builder()
                .nome(r.nome())
                .preco(r.preco())
                .sabor(r.sabor())
                .opcionais(r.opcionais())
                .build();
    }

    @Override
    public ProdutoResponse toResponse(Produto e) {
        if (Objects.isNull( e )) return null;

        return new ProdutoResponse(
                e.getId(),
                e.getNome(),
                e.getPreco(),
                e.getSabor(),
                e.getOpcionais()
        );
    }

    @Override
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Produto> findAll(Example<Produto> example) {
        return repo.findAll( example );
    }

    @Override
    public Produto findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Produto save(ProdutoRequest r) {
        if (Objects.isNull(r)) return null;
        return repo.save( toEntity(r) );
    }
}
