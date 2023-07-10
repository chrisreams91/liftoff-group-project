package org.launchcode.liftoffgroupproject.controllers;


import org.launchcode.liftoffgroupproject.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    @GetMapping("add")
    public String displayAddTaskForm(Model model) {
        return "add";
    }

}
