package org.launchcode.liftoffgroupproject.controllers;


import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("add")
    public String displayAddTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "add";
    }

    @PostMapping("add")
    public String processAddTaskForm (@ModelAttribute @Valid Task newTask, Model model, Errors errors){
       if(errors.hasErrors()) {
           model.addAttribute("task", "Add Task");
           LocalDate startDate = newTask.getStartDate();
           LocalDate dueDate = newTask.getDueDate();
           return "add";
       }

       taskRepository.save(newTask);
       return "redirect:";
    }
}
