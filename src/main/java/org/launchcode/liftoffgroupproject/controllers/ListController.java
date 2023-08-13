package org.launchcode.liftoffgroupproject.controllers;

import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.models.Task;
import org.launchcode.liftoffgroupproject.models.TaskData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private TaskRepository taskRepository;


    @RequestMapping("")
    public String list(Model model) {
     model.addAttribute("tasks", taskRepository.findAll());
     return "list";
    }

}
