package com.backend.controllers;

import com.backend.dto.impl.RoleDto;
import com.backend.mapper.RoleMapper;
import com.backend.model.RoleEntity;
import com.backend.repository.RoleRepository;
import com.backend.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${server.adminEndPoint}/role")
public class RoleController extends BaseController<RoleEntity,
                                    RoleDto.Request.Role,RoleDto.Response.Role,
                                    BaseService<RoleEntity, RoleRepository>,
                                    RoleMapper, RoleRepository> {
    @Autowired
    public RoleController(BaseService<RoleEntity, RoleRepository> service, RoleMapper mapper) {
        super(service, mapper);
    }
}
