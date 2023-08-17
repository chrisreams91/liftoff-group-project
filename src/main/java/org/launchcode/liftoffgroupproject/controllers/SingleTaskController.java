package org.launchcode.liftoffgroupproject.controllers;

import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("task")
public class SingleTaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("taskDetails")
    public String displayTaskDetails(@RequestParam(required = false) Integer taskId, Model model) {

        Optional<Task> result = taskRepository.findById(taskId);

        if (taskId == null) {
            model.addAttribute("title", "All Tasks");
            model.addAttribute("tasks", taskRepository.findAll());
        } else {
            model.addAttribute("task", taskRepository.findById(taskId).get());
        }
            return "taskDetails/taskDetails";
        }

    }


