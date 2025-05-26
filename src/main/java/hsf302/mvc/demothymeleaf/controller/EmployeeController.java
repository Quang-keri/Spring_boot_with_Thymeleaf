package hsf302.mvc.demothymeleaf.controller;

import hsf302.mvc.demothymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
