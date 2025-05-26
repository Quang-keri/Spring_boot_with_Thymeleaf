package hsf302.mvc.demothymeleaf.service;

import hsf302.mvc.demothymeleaf.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);

}
