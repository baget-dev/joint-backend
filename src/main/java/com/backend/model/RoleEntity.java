package com.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_role",
        uniqueConstraints = @UniqueConstraint(columnNames = {"str_name"}))
public class RoleEntity extends BaseEntity {
    @NotNull
    @Column(name = "str_name", unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UserEntity> users;
}
