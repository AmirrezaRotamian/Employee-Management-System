package com.app.iota.entity;

import com.app.iota.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String mobile;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Address> addresses = new ArrayList<>();
}
