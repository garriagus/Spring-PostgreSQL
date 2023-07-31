package service;

import model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee updateEmployee(long id, Employee updatedEmployee);

    boolean deleteEmployee(long id);
}