package com.backend.dto.impl;

import com.backend.dto.RequestDTO;
import com.backend.dto.ResponseDTO;
import com.backend.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public enum UserDto{;
    public enum Request {;
        @Getter
        @Setter
        public static class CreateUser implements RequestDTO {
            String userName;
            String firstName;
            String lastName;
            String email;
            String password;
        }
    }
    public enum Response {;
        @Getter
        @AllArgsConstructor
        public static class UserLight implements ResponseDTO {
            String userName;
            String firstName;
            String lastName;
        }
        @Getter
        @AllArgsConstructor
        public static class UserHeavy implements ResponseDTO {
            String userName;
            String firstName;
            String lastName;
            String email;
            String password;
        }
    }
}
