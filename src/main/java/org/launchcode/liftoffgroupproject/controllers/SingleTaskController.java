package org.launchcode.liftoffgroupproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("task")
public class SingleTaskController {

//    @Autowired
//    private JobRepository jobRepository;
//
//    @RequestMapping("")
//    public String index(Model model) {
//
//        model.addAttribute("title", "My Tasks");
//        model.addAttribute("tasks", taskRepository.findAll());
//
//        return "index";
//    }

    @GetMapping("")
    public String displaySingleTask() {
        return "single-task";
    }
//}
//    @GetMapping("view/{taskId}")
//    public String displayViewTask(Model model, @PathVariable int taskId) {
//        model.addAttribute("task", taskRepository.findById(taskId));
////        return "view";
//
//
//        Optional optTask = taskRepository.findById(taskId);
//        if (optTask.isPresent()) {
//            Task task = (Task) optTask.get();
//            model.addAttribute("task", task);
//
//            return "view";
//        } else {
//            return "redirect:../";
//        }
    }