package EmployeeManagement.employee.demo.repository;

import EmployeeManagement.employee.demo.entitiy.Employee;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT employee FROM Employee employee WHERE employee.firstName  LIKE %:keyword%")
    public List<Employee> search(@Param("keyword") String keyword);
}
