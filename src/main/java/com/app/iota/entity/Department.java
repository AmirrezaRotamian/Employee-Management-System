package com.app.iota.entity;

import com.app.iota.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany
    @JoinColumn(name = "manager_id")
    private List<Manager> manager = new ArrayList<>();
}
