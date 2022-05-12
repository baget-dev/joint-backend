package com.backend.services;

import com.backend.model.BaseEntity;
import com.backend.repository.LongKeyRepository;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface BaseService <E extends BaseEntity, S extends LongKeyRepository<E>> {
    E create(E dto);
    Iterable<E> saveAll(Iterable<E> dtoList);
    Optional<E> findById(Long id);
    Page<E> findAll(int page);
    Iterable<E> findAll();
    Iterable<E> findByIds(Iterable<Long> idList);
    boolean delete(E dto);
    boolean deleteById(Long id);
}