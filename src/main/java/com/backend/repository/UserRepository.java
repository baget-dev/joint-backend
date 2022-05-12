package com.backend.repository;

import com.backend.model.UserEntity;

public interface UserRepository extends LongKeyRepository<UserEntity>{
    UserEntity findByUserName(String userName);
    boolean existsByUserName(String userName);
}
