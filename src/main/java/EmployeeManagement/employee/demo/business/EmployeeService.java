package EmployeeManagement.employee.demo.business;

import EmployeeManagement.employee.demo.entitiy.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getALlEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeById(long id);
    void deleteEmployeeById(long id);

    List<Employee> searchEmployees(String employeeName);
}
