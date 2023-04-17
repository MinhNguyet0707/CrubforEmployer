package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Employer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employers")
public class EmployerController {

     static List<Employer> employers = new ArrayList<>();

    @GetMapping("/add")
    public String showAddForm(org.springframework.ui.Model model) {
        model.addAttribute("employer", new Employer());
        return "add-employer";
    }

    @PostMapping("/save")
    public String addEmployer(@ModelAttribute("employer") Employer employer, org.springframework.ui.Model model) {
        int id = employers.size() + 1;
        employer.setId(id);
        employers.add(employer);
        model.addAttribute("employers", employers);
        return "employers";
    }

    @GetMapping("list")
    public String showList(Model model) {
        model.addAttribute("employers", employers);
        return "employers";
    }
}

