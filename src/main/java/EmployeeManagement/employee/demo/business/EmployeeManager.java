package EmployeeManagement.employee.demo.business;

import EmployeeManagement.employee.demo.entitiy.Employee;
import EmployeeManagement.employee.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getALlEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);

    }

    @Override
    public Employee getEmployeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee =null;
        if(optional.isPresent()){
            employee = optional.get();
        }else{
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> searchEmployees(String employeeName) {
        // kontroller yapildi
        return this.employeeRepository.search(employeeName);
    }


}



