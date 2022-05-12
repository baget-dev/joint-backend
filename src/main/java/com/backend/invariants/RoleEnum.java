package com.backend.invariants;

import com.backend.dto.impl.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleEnum {
    ROLE_USER(new RoleDto.Request.Role("ROLE_USER")), ROLE_ADMIN(new RoleDto.Request.Role("ROLE_USER"));
    private RoleDto.Request.Role role;
}
