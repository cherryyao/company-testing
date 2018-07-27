package com.example.demo.controller;

import com.example.demo.Service.CompaniesService;
import com.example.demo.model.Companies;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompaniesController {
    @Autowired
    CompaniesService companiesService;

    @GetMapping("/companies")
    public List<Companies> getAllCompanies(){
        return companiesService.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    public Companies getSpecificCompanies(@PathVariable int id){
        return companiesService.getSpecificCompanies(id);
    }

    @GetMapping("/companies/{id}/employees")
    public List<Employee> getSpecificCompanyEmployees(@PathVariable int id){
        return companiesService.getSpecificCompanies(id).getEmployeeList();
    }

    @GetMapping("/companies/page/{page}/pageSize/{size}")
    public List<Companies> Paging(@PathVariable int page,@PathVariable int size){
        return companiesService.paging(page,size);
    }

    @PostMapping("/companies")
    public List<Companies> addCompany(@RequestBody Companies company) {
        int id = company.getId();
        String companyName = company.getCompanyName();
        int EmployeesNumber = company.getEmployeesNumber();
        List<Employee> employeeList =company.getEmployeeList();
        return companiesService.addCompany(id,companyName,EmployeesNumber,employeeList);
    }

    @PutMapping("/companies/{id}")
    public List<Companies> updateCompanies(@PathVariable int id,@RequestBody Companies companies){
        return companiesService.updateCompanies(id,companies);
    }

    @DeleteMapping("companies/{id}")
    public List<Companies> deleteCompany(@PathVariable int id){
        return companiesService.deleteCompany(id);
    }








}
