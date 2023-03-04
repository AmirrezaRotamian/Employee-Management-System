package com.app.iota.entity;

import com.app.iota.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department extends BaseEntity {
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
