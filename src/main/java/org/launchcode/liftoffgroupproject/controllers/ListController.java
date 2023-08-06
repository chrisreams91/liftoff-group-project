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

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("description", "Description");
        columnChoices.put("start date", "Start Date");
        columnChoices.put("due date", "Due Date");
        columnChoices.put("name", "Name");

    }


    @RequestMapping("")
    public String list(Model model) {
     model.addAttribute("tasks", taskRepository.findAll());
     return "list";
    }

    @RequestMapping(value = "tasks")
    public String listTasksByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Task> tasks;
        if (column.toLowerCase().equals("all")){
            tasks = taskRepository.findAll();
            model.addAttribute("title", "All Tasks");
        } else {
            tasks = TaskData.findByColumnAndValue(column, value, taskRepository.findAll());
            model.addAttribute("title", "Tasks with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("tasks", tasks);

        return "list";
    }
}
