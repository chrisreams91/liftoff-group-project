package org.launchcode.liftoffgroupproject.controllers;

import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.data.UserRepository;
import org.launchcode.liftoffgroupproject.models.PublishTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "list")
public class ListController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;


    @RequestMapping("")
    public String list(Model model) {
     model.addAttribute("tasks", taskRepository.findAll());
     return "list";
    }

    @PostMapping("/{email}")
    public String email() {
       PublishTopic.sendMessage();
        return "redirect:/list";
    }
}
