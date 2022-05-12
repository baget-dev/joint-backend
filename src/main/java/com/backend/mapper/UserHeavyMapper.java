package com.backend.mapper;

import com.backend.dto.impl.UserDto;
import com.backend.model.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserHeavyMapper extends BaseMapper<UserEntity,
        UserDto.Request.CreateUser,
        UserDto.Response.UserHeavy>{
}
