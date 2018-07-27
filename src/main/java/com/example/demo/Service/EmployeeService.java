package com.example.demo.Service;

import com.example.demo.Dao.EmployeeDao;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService implements EmployeeDao {

    private List<Employee> EmployeeList = new ArrayList<>();

    @Override
    public List<Employee> getAllEmployees() {
//        EmployeeList.add(new Employee(1,"aaa",22,"male"));
//        EmployeeList.add(new Employee(2,"bbbb",22,"female"));
        return EmployeeList;
    }

    @Override
    public  List<Employee> addEmployees(int id,String name,int age,String gender){
        EmployeeList.add(new Employee(id,name,age,gender));
        return EmployeeList;
    }

    @Override
    public List<Employee> updateEmployee(int id,Employee employee){
        for (Employee oldEmployee:EmployeeList)
        {
            if (id == oldEmployee.getId()){
                oldEmployee.setName(employee.getName());
                oldEmployee.setAge(employee.getAge());
                oldEmployee.setGender(employee.getGender());
                System.out.println(oldEmployee);
            }
        }
        return EmployeeList;
    }

    @Override
    public List<Employee> deleteEmployee(int id){
        for(Employee oldEmployee:EmployeeList){
            if (id == oldEmployee.getId()){
                EmployeeList.remove(oldEmployee);
               return EmployeeList;
            }
        }
        return null;
    }

    @Override
    public Employee searchEmployee(int id){
        for(Employee oldEmployee:EmployeeList){
            if (id == oldEmployee.getId()){
                return oldEmployee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> filterMale(){
        return EmployeeList.stream().filter(employee -> employee.getGender().equals("male")).collect(Collectors.toList());
    }



}
