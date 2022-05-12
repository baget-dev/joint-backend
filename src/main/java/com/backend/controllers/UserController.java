package com.backend.controllers;

import com.backend.dto.impl.RoleDto;
import com.backend.dto.impl.UserDto;
import com.backend.mapper.UserHeavyMapper;
import com.backend.model.UserEntity;
import com.backend.repository.UserRepository;
import com.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${server.adminEndPoint}/user")
public class UserController extends BaseController<UserEntity,
                                                    UserDto.Request.CreateUser,
                                                    UserDto.Response.UserHeavy,
                                                    UserService,UserHeavyMapper,
                                                    UserRepository>  {

    @Autowired
    public UserController(UserService service, UserHeavyMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/role")
    public boolean getUserRoles(UserEntity entity) {
        return super.delete(entity);
    }

    @PutMapping("/role/{id}")
    public UserEntity addRoleForUser(@PathVariable Long id, @RequestBody RoleDto.Request.Role role) {
        return service.addRoleForUser(id, role);
    }
}
