package com.backend.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class UserEntity extends BaseEntity{

    @Column(name = "str_token")
    String token;
    @Column(name = "str_name")
    String name;
}
