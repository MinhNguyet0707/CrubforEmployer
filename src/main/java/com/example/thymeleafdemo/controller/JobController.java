package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Employer;
import com.example.thymeleafdemo.model.Job;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jobs")
public class JobController {

    static List<Job> jobs = new ArrayList<>();

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("job", new Job());
        return "add-job";
    }

    @PostMapping("/save")
    public String addJob(@ModelAttribute("job") Job job, Model model) {
        int id = jobs.size() + 1;
        job.setId(id);
        jobs.add(job);
        model.addAttribute("jobs", jobs);
        return "jobs";
    }

    @GetMapping("list")
    public String showList(Model model) {
        model.addAttribute("jobs", jobs);
        return "jobs";
    }
}