package com.backend.repository;

import com.backend.model.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends LongKeyRepository<ProductEntity>{
}
