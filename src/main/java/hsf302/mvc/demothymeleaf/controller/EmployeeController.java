package hsf302.mvc.demothymeleaf.controller;

import hsf302.mvc.demothymeleaf.model.Employee;
import hsf302.mvc.demothymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

   //display  list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {

        return  findPaginated(1,model);
    }


    @GetMapping("/showNewEmployeeForm")
    public  String showNewEmployeeForm(Model model){
        //create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save employee to database
        this.employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public  String showFormForUpdate(@PathVariable (value = "id") Long id,Model model){
        //get employee from the service
        Employee employee = employeeService.getEmployeeById(id);


        //update
        model.addAttribute("employee",employee);
        return "update_employee";

    }
    @GetMapping("/deleteById/{id}")
    public  String deleteById(@PathVariable (value = "id") Long id){
        //delete
        employeeService.deleteEmployeeById(id);
        return "redirect:/";

    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,Model model ){
        int pageSize = 5; // có thể change số bất kì
        Page<Employee> page = employeeService.findpaginated(pageNo, pageSize);
        List<Employee> listEmployees = page.getContent();
        model.addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees",listEmployees);
        return  "index";

    }
}
