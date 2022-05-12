package com.backend.dto.impl;

import com.backend.dto.RequestDTO;
import com.backend.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public enum AuthDto {;

    public enum Request {;
        @Getter
        @Setter
        public static class AuthUser implements RequestDTO {
            String userName;
            String password;
        }
    }
    public enum Response {;
        @Getter
        @AllArgsConstructor
        public static class AuthUser implements ResponseDTO {
            String token;
            String userName;
        }
    }
}
