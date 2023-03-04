package com.app.iota.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date creationDate;
    private Date lastModifiedDate;

    @PrePersist
    public void onPrePersist() {
        creationDate = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        lastModifiedDate = new Date();
    }
}
