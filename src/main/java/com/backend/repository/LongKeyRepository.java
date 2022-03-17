package com.backend.repository;

import com.backend.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongKeyRepository<E extends BaseEntity> extends PagingAndSortingRepository<E, Long> {
}