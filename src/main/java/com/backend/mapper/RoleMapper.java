package com.backend.mapper;

import com.backend.dto.impl.RoleDto;
import com.backend.model.RoleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<RoleEntity,
                                    RoleDto.Request.Role,
                                    RoleDto.Response.Role>{
}
