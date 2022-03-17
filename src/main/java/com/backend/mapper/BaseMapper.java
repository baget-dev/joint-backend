package com.backend.mapper;

import com.backend.dto.RequestDTO;
import com.backend.dto.ResponseDTO;
import com.backend.model.BaseEntity;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public interface BaseMapper<E extends BaseEntity, Q extends RequestDTO, S extends ResponseDTO> {
    E toEntity(Q dto);
    Iterable<E> toEntityList(Iterable<Q> dtoList);
    S toDto(E entity);
    Iterable<S> toDtoList(Iterable<E> entityList);
}
