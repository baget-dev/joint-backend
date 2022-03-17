package com.backend.repository;

import com.backend.model.RoleEntity;

public interface RoleRepository extends LongKeyRepository<RoleEntity> {
    RoleEntity findByName(String name);
}
