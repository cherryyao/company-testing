package com.example.demo.controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @PostMapping("/employees")
    public List<Employee> add(@RequestBody Employee employee) {
        int id = employee.getId();
        String name = employee.getName();
        int age = employee.getAge();
        String gender = employee.getGender();
        return employeeService.addEmployees(id,name,age,gender);
    }

    @PutMapping("/employees/{id}")
    public List<Employee> update(@PathVariable int id,@RequestBody Employee employee)
    {
          return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/employees/{id}")
    public List<Employee> delete(@PathVariable int id)
    {
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/{id}")
    public Employee search(@PathVariable int id)
    {
        return employeeService.searchEmployee(id);
    }

    @GetMapping("/employees/male")
    public List<Employee> filterMale(){
        return employeeService.filterMale();
    }

}
