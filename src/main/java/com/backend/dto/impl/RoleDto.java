package com.backend.dto.impl;

import com.backend.dto.RequestDTO;
import com.backend.dto.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public enum RoleDto {;
    public enum Request {;
        @Getter
        @Setter
        public static class Role implements RequestDTO {
            String id;
            String name;
            public Role(String name) {
                this.name = name;
            }
        }
    }
    public enum Response {;
        @Getter
        @AllArgsConstructor
        public static class RoleName implements ResponseDTO {
            String id;
            String name;
        }
        @Getter
        @AllArgsConstructor
        public static class Role implements ResponseDTO {
            String name;
        }
    }
}
