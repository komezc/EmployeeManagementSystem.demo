package EmployeeManagement.employee.demo.controller;


import EmployeeManagement.employee.demo.business.EmployeeService;
import EmployeeManagement.employee.demo.entitiy.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("ListEmployee", employeeService.getALlEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        //create model attribure to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        //get employee from the service
        Employee employee = employeeService.getEmployeById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        // call delete employee method

        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }



    @PostMapping("/searchEmployee")
    public String searchEmployee(@RequestParam("name") String name, Model model) {
        model.addAttribute("ListEmployee", employeeService.searchEmployees(name));
        return "index";
    }


  /*  @RequestMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        List<Employee> result = employeeService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);

        return mav;
    }*/


}








