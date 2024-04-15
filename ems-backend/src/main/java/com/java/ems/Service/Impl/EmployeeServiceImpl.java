package com.java.ems.Service.Impl;

import com.java.ems.EmployeeMapper.EmployeeMapper;
import com.java.ems.Entity.Employee;
import com.java.ems.Exception.NoRecordFoundException;
import com.java.ems.Repository.EmployeeRepository;
import com.java.ems.RequestAndResponse.EmployeeRequestAndResponse;
import com.java.ems.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeRequestAndResponse saveEmployee(EmployeeRequestAndResponse employeeRequestAndResponse) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeRequestAndResponse);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeRequestAndResponse(savedEmployee);
    }

    @Override
    public EmployeeRequestAndResponse getEmployeeById(Long employeeId) {
        Employee employeeResult = employeeRepository.findById(employeeId).
                orElseThrow(
                        ()->new NoRecordFoundException("Employee Not Exits With Given Id : "+employeeId)
                );
        return EmployeeMapper.mapToEmployeeRequestAndResponse(employeeResult);
    }

    @Override
    public List<EmployeeRequestAndResponse> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(EmployeeMapper::mapToEmployeeRequestAndResponse).collect(Collectors.toList());
    }

    @Override
    public EmployeeRequestAndResponse updateEmployeeById(Long employeeId, EmployeeRequestAndResponse employeeRequestAndResponse) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(
                        ()->new NoRecordFoundException("Employee Not Exits With Given Id : "+employeeId)
                );
            employee.setFirstName(employeeRequestAndResponse.getFirstName());
            employee.setLastName(employeeRequestAndResponse.getLastName());
            employee.setEmail(employeeRequestAndResponse.getEmail());
            employee.setMobileNumber(employeeRequestAndResponse.getMobileNumber());
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeRequestAndResponse(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(
                        ()-> new NoRecordFoundException("Employee Not Exits With Given Id : "+employeeId)
                );
        employeeRepository.deleteById(employeeId);
    }
}
