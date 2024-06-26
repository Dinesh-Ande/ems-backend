package com.java.ems.Controller;

import com.java.ems.Constants.EmployeeUrlConstants;
import com.java.ems.RequestAndResponse.EmployeeRequestAndResponse;
import com.java.ems.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(EmployeeUrlConstants.APIS_BASE_URL)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(EmployeeUrlConstants.CREATE)
    public ResponseEntity<EmployeeRequestAndResponse> saveEmployee(@RequestBody EmployeeRequestAndResponse employeeRequestAndResponse){
        EmployeeRequestAndResponse savedEmployee = employeeService.saveEmployee(employeeRequestAndResponse);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping(EmployeeUrlConstants.GET)
    public ResponseEntity<EmployeeRequestAndResponse> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeRequestAndResponse employeeRequestAndResponse = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeRequestAndResponse);
    }

    @GetMapping(EmployeeUrlConstants.GET_ALL)
    public ResponseEntity<List<EmployeeRequestAndResponse>> getAllEmployees(){
        List<EmployeeRequestAndResponse> employeeRequestAndResponseList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeRequestAndResponseList);
    }

    @PutMapping(EmployeeUrlConstants.UPDATE)
    public ResponseEntity<EmployeeRequestAndResponse> updateEmployeeById(@PathVariable("id") Long employeeId,@RequestBody EmployeeRequestAndResponse employeeRequestAndResponse){
        EmployeeRequestAndResponse updatedEmployee = employeeService.updateEmployeeById(employeeId,employeeRequestAndResponse);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping(EmployeeUrlConstants.DELETE)
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully");
    }

}
