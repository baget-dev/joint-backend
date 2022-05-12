package com.backend.services.impl;

import com.backend.model.RoleEntity;
import com.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<RoleEntity, RoleRepository> {
    @Autowired
    public RoleServiceImpl(RoleRepository repo) {
        super(repo, 10);
    }
}
