package br.com.benefrancis.benezinhopizzaria.resource;

import org.springframework.http.ResponseEntity;

public interface ResourceDTO<Request, Response> {

    ResponseEntity<Response> findAll();

    ResponseEntity<Response> findById(Long id);

    ResponseEntity<Response> save(Request r);
}
