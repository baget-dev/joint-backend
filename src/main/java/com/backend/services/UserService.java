package com.backend.services;

import com.backend.dto.impl.RoleDto;
import com.backend.model.UserEntity;
import com.backend.repository.UserRepository;

public interface UserService extends BaseService<UserEntity, UserRepository>{
    UserEntity findByUserName(String userName);
    boolean existsByUserName(String userName);
    UserEntity addRoleForUser(Long id, RoleDto.Request.Role role);
}
