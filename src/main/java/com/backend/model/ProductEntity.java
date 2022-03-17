package com.backend.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Getter
@Setter
@Table( name = "prod_prod",
        uniqueConstraints = @UniqueConstraint(columnNames = {"str_name"}))
public class ProductEntity extends BaseEntity {
    @NotNull
    @Column(name = "str_name",unique = true)
    private String name;
}
