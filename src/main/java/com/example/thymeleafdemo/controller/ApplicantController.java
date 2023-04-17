package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Applicant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/applicants")
public class ApplicantController {

    static List<Applicant> applicants= new ArrayList<>();

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "add-applicant";
    }

    @PostMapping("/save")
    public String addApp(@ModelAttribute("applicant") Applicant applicant, Model model) {
        int id = applicants.size() + 1;
        applicant.setId(id);
        applicants.add(applicant);
        model.addAttribute("applicants", applicants);
        return "/applicants";
    }

    @GetMapping("list")
    public String showList(Model model) {
        model.addAttribute("applicants", applicants);
        return "applicants";
    }
}


