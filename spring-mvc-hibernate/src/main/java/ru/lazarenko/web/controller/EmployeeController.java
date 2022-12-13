package ru.lazarenko.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lazarenko.web.entity.Employee;
import ru.lazarenko.web.service.EmployeeService;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployeesPage(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/employee/new")
    public String getNewEmployeePage(Model model){
        model.addAttribute("employee", new Employee());
        return "new_employee";
    }

    @PostMapping("employees")
    public String createEmployeeAndRedirect(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/delete")
    public String getDeleteEmployeePage(){
        return "delete_employee";
    }

    @PostMapping("/employee/delete")
    public String deleteEmployeePage(@RequestParam Integer id){
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("/employee/change")
    public String getChangeEmployeePage(Model model){
        model.addAttribute("employee", new Employee());
        return "change_employee";
    }

    @GetMapping("/employee/select")
    public String getSelectEmployeePage(){
        return "show_employee";
    }

    @PostMapping("/employee/show-one")
    public String showSelectEmployee(@RequestParam Integer id, Model model){
        Employee employeeById = employeeService.getEmployeeById(id);
        model.addAttribute("employees", List.of(employeeById));
        return "employees";
    }

    @PostMapping("employee/update")
    public String showResultUpdateEmployee(@ModelAttribute Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/grouping/employee")
    public String getPageSelectTypeGroup(){
        return "form_group_employee";
    }

    @GetMapping("/grouping/result")
    public String makeResultGroup(@RequestParam String avg, Model model){
        Map<String, Double> result = employeeService.getMapDepartmentAggregationSalary(avg);
        model.addAttribute("result", result);
        return "result_group";
    }
}