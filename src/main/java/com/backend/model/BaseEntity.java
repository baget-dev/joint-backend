package com.backend.model;


import com.backend.invariants.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedDate
    @Column(name = "dt_created")
    private Date created;

    @LastModifiedDate
    @Column(name = "dt_updated")
    private Date updated;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;
}
