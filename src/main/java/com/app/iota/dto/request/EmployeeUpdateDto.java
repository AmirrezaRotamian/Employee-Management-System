package com.app.iota.dto.request;

import com.app.iota.entity.Address;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeUpdateDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private List<Address> addresses = new ArrayList<>();
    private long departmentId;
}
