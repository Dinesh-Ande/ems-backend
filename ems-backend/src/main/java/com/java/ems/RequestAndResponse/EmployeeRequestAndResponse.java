package com.java.ems.RequestAndResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestAndResponse {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private Long mobileNumber;
}
