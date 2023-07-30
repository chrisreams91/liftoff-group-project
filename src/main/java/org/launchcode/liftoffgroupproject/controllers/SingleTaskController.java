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

//        if (result.isEmpty()) {
//            model.addAttribute("title", "Invalid Task ID: " + taskId);
//        } else {
//            Task task = result.get();
////            model.addAttribute("title", task.getName() + " Details");
//            model.addAttribute("title", task.getName() + " Details");
//            model.addAttribute("task", task);
////            model.addAttribute("tags", "task.getTasks());
//        }
//
//            return "taskDetails/taskDetails";

        //this code works
        if (taskId == null) {
            model.addAttribute("title", "All Tasks");
            model.addAttribute("tasks", taskRepository.findAll());
        } else {
            model.addAttribute("task", taskRepository.findById(taskId).get());
        }
            return "taskDetails/taskDetails";

//            if (taskId == null) {
//                model.addAttribute("title", "All Tasks");
//                model.addAttribute("tasks", taskRepository.findAll());
//            } else {
////            Optional<TaskCategory> result = taskCategoryRepository.findById(taskId);
////            if (result.isEmpty()) {
////                model.addAttribute("title", "Invalid Category Id: " + categoryId);
////            } else {
////                TaskCategory category = result.get();
////                model.addAttribute("title", "Tasks in Category: " + category.getName());
////                model.addAttribute("tasks", category.getTasks());
////            }
//                model.addAttribute("task", taskRepository.findById(taskId).get());
////            model.addAttribute("tasks", category.getTasks());


//    @GetMapping("")
//    public String displayTaskDetails() {return "taskDetails/taskDetails";}
        }

    }


