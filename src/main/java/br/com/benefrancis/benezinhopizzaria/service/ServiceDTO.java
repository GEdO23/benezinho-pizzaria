package br.com.benefrancis.benezinhopizzaria.service;

import org.springframework.data.domain.Example;

import java.util.List;

public interface ServiceDTO<Entity, Request, Response> {

    Entity toEntity(Request r);

    Response toResponse(Entity e);

    List<Entity> findAll();

    List<Entity> findAll(Example<Entity> example);

    Entity findById(Long id);

    Entity save(Request r);

}
