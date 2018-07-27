package com.example.demo.Service;

import com.example.demo.Dao.CompaniesDao;
import com.example.demo.model.Companies;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CompaniesService implements CompaniesDao {
    private List<Companies> CompaniesList = new ArrayList<>();


    @Override
    public List<Companies> getAllCompanies(){
        Employee employee1 = new Employee(1,"aaa",22,"male");
        Employee employee2 = new Employee(2,"bbb",22,"male");
        List<Employee> EmployeeList = new ArrayList<>();
        EmployeeList.add(employee1);
        EmployeeList.add(employee2);
        CompaniesList.add(new Companies(1,"alibaba",2,EmployeeList));
        CompaniesList.add(new Companies(2,"OOCL",2,EmployeeList));
        return CompaniesList;
    }

    @Override
    public Companies getSpecificCompanies(int id){
        for(Companies companies:CompaniesList){
            if (id == companies.getId()){
                return companies;
            }
        }
        return null;
        //return CompaniesList.stream().filter(companies -> companies.getId()==id)
    }

    @Override
    public List<Companies> addCompany(int id, String companyName, int employeesNumber, List<Employee> employeeList){
        CompaniesList.add(new Companies(id,companyName,employeesNumber,employeeList));
        return CompaniesList;
    }

    @Override
    public List<Companies> updateCompanies(int id, Companies companies){
        for (Companies company:CompaniesList)
        {
            if (id == company.getId()){
                company.setCompanyName(companies.getCompanyName());
                company.setEmployeesNumber(companies.getEmployeesNumber());
                company.setEmployeeList(companies.getEmployeeList());
            }
        }
        return CompaniesList;
    }

    @Override
    public List<Companies> deleteCompany(int id){
        for(Companies company:CompaniesList){
            if (id == company.getId()){
                CompaniesList.remove(company);
                return CompaniesList;
            }
        }
        return null;
    }
    @Override
    public  List<Companies> paging(int page, int pageSize){
        List<Companies> result = new ArrayList<>();
        int start = (page-1)*pageSize;
        int end = (start+pageSize)>CompaniesList.size() ? CompaniesList.size() : (start+pageSize);
        for(int i=start;i<end;i++){
            result.add(CompaniesList.get(i));
        }
        return result;
    }

}
