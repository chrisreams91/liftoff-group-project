package org.launchcode.liftoffgroupproject.controllers;

import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.models.Task;
import org.launchcode.liftoffgroupproject.models.TaskData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;


@Controller
@RequestMapping("search")
public class SearchController {

    static HashMap<String, String> columnChoices = new HashMap<>();

    public SearchController () {

        columnChoices.put("all", "All");
        columnChoices.put("name", "Name");
        columnChoices.put("description", "Description");
        columnChoices.put("start date", "Start Date");
        columnChoices.put("due date", "Due Date");

    }

    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Task> tasks;
        if (searchType.toLowerCase().equals("all")){
            tasks = taskRepository.findAll();
            model.addAttribute("title", "All Tasks");

        } else {
            tasks = TaskData.findByColumnAndValue(searchType, searchTerm, taskRepository.findAll());
            model.addAttribute("title", "Tasks with " + columnChoices.get(searchType) + ": " + searchTerm);
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("columns", columnChoices);

        return "search";

    }
}