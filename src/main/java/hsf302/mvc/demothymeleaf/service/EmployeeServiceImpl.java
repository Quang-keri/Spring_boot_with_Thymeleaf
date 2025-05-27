package hsf302.mvc.demothymeleaf.service;

import hsf302.mvc.demothymeleaf.model.Employee;
import hsf302.mvc.demothymeleaf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void saveEmployee(Employee employee) {
      employeeRepository.save(employee);
    }
    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
       if(optional.isPresent()){
             employee = optional.get();
       }else{
           throw  new RuntimeException("EMployee not fount id"+ id);
       }
       return employee;
    }
    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public Page<Employee> findpaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return employeeRepository.findAll(pageable); // Placeholder implementation
    }

}
