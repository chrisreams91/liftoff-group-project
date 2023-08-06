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

import static org.launchcode.liftoffgroupproject.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

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
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            tasks = taskRepository.findAll();
        } else {
            tasks = TaskData.findByColumnAndValue(searchType, searchTerm, taskRepository.findAll());
        }
        model.addAttribute("title", "Tasks with " +  columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("columns", columnChoices);
        model.addAttribute("tasks", tasks);

        return "search";

    }
}