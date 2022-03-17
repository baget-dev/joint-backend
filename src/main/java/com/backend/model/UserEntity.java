package com.backend.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table( name = "users",
        uniqueConstraints = @UniqueConstraint(columnNames = {"str_name","str_email"}))
public class UserEntity extends BaseEntity {
    @NotNull
    @Column(name = "str_name",unique = true)
    private String userName;
    @NotNull
    @Column(name = "str_firstName")
    private String firstName;
    @NotNull
    @Column(name = "str_lastName")
    private String lastName;
    @NotNull
    @Column(name = "str_email",unique = true)
    private String email;
    @NotNull
    @Column(name = "str_password")
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
               joinColumns = {@JoinColumn(name = "ref_user", referencedColumnName = "id")},
               inverseJoinColumns = {@JoinColumn(name = "ref_role", referencedColumnName = "id")})
    private Set<RoleEntity> roles;
}
