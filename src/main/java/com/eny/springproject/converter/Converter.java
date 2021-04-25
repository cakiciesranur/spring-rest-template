package com.eny.springproject.converter;

public interface Converter<DTO, Entity, Resource> {

    Resource toResource(Entity entity);

    Entity toEntity(DTO dto);
}
