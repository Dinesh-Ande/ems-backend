package com.java.ems.EmployeeMapper;

import com.java.ems.Entity.Employee;
import com.java.ems.RequestAndResponse.EmployeeRequestAndResponse;

public class EmployeeMapper {

    public static EmployeeRequestAndResponse mapToEmployeeRequestAndResponse(Employee employee){
        return new EmployeeRequestAndResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getMobileNumber()
        );
    }
    public  static Employee mapToEmployee(EmployeeRequestAndResponse employeeRequestAndResponse){
        return new Employee(
                employeeRequestAndResponse.getId(),
                employeeRequestAndResponse.getFirstName(),
                employeeRequestAndResponse.getLastName(),
                employeeRequestAndResponse.getEmail(),
                employeeRequestAndResponse.getMobileNumber()
        );
    }
}
