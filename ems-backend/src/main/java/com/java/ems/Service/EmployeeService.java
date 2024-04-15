package com.java.ems.Service;

import com.java.ems.RequestAndResponse.EmployeeRequestAndResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeRequestAndResponse saveEmployee(EmployeeRequestAndResponse employeeRequestAndResponse);
    EmployeeRequestAndResponse getEmployeeById(Long employeeId);
    List<EmployeeRequestAndResponse> getAllEmployees();
    EmployeeRequestAndResponse updateEmployeeById(Long employeeId, EmployeeRequestAndResponse employeeRequestAndResponse);
    void deleteEmployeeById(Long employeeId);
}
