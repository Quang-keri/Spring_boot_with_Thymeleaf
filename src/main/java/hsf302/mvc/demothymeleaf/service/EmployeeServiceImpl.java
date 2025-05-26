package hsf302.mvc.demothymeleaf.service;

import hsf302.mvc.demothymeleaf.model.Employee;
import hsf302.mvc.demothymeleaf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
   private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        // This method should interact with the repository to fetch all employees.
        // For now, we can return an empty list or throw an exception.
        return employeeRepository.findAll(); // Placeholder implementation
    }
}
