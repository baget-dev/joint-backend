package com.backend.services.impl;

import com.backend.dto.impl.RoleDto;
import com.backend.invariants.StatusEnum;
import com.backend.mapper.RoleMapper;
import com.backend.model.RoleEntity;
import com.backend.model.UserEntity;
import com.backend.repository.RoleRepository;
import com.backend.repository.UserRepository;
import com.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UserRepository> implements UserService {

    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleMapper roleMapper;
    @Autowired
    public UserServiceImpl(UserRepository repo, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder, RoleMapper roleMapper) {
        super(repo, 10);
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleMapper = roleMapper;
    }

    @Override
    public UserEntity create(UserEntity user) {
        RoleEntity role = roleRepository.findByName("ROLE_USER");
        Set<RoleEntity> userRoles = new HashSet<>();
        userRoles.add(role);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(StatusEnum.ACTIVE);

        return super.create(user);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return repo.existsByUserName(userName);
    }

    @Override
    public UserEntity findByUserName(String userName) {
        return repo.findByUserName(userName);
    }

    @Override
    public UserEntity addRoleForUser(Long id, RoleDto.Request.Role role) {
        UserEntity user = this.findById(id).orElse(null);
        if (Objects.nonNull(user)) {
            user.getRoles().add(roleMapper.toEntity(role));
            return this.create(user);
        }
        return null;
    }
}
