package hsf302.mvc.demothymeleaf.controller;

import hsf302.mvc.demothymeleaf.model.Employee;
import hsf302.mvc.demothymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

   //display  list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
       model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index"; // This should return the name of the view template to be rendered
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
    public  String deleteById(@PathVariable (value = "id") Long id,Model model){
        //delete
        employeeService.deleteEmployeeById(id);
        return "redirect:/";

    }
}
