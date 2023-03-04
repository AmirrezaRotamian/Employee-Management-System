package com.app.iota.entity;

import com.app.iota.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager")
public class Manager extends BaseEntity {
    private String name ;
}
