package org.launchcode.liftoffgroupproject.controllers;


import org.launchcode.liftoffgroupproject.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("")
public class TaskController {
    @GetMapping("add")
    public String displayAddTaskForm(Model model) {
        model.addAttribute("task", new Task());
//        model.addAttribute("date", LocalDate.now());
        return "add";
    }



}
