package org.launchcode.liftoffgroupproject.controllers;


import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.data.UserRepository;
import org.launchcode.liftoffgroupproject.models.Task;
import org.launchcode.liftoffgroupproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("add")
    public String displayAddTaskForm(Model model) {
        model.addAttribute("task", new Task());
//        model.addAttribute("date", LocalDate.now());
        return "add";
    }

    @PostMapping("add")
    public String processAddTaskForm (@ModelAttribute @Valid Task newTask,Model model, Errors errors){
       if(errors.hasErrors()) {
           model.addAttribute("task", "Add Task");
           return "add";
       }

//        Optional<User> result = userRepository.findById(userId);
//        if (result.isPresent()) {
//            User user = result.get();
//            newTask.setUser(user);
//        }

       taskRepository.save(newTask);
       return "redirect:";
    }

    @GetMapping("edit/{taskId}")
    public String displayEditForm(Model model , @PathVariable int taskId){
        model.addAttribute("task", "Edit Task");
        model.addAttribute("task", taskRepository.findById(taskId));
        return "edit";
    }

    @PostMapping("edit")
    public String processEditForm(Integer id, String name, String description, String startDate, String dueDate) {
        Task task = taskRepository.findById(id).get();
        task.setName(name);
        task.setDescription(description);
        task.setStartDate(startDate);
        task.setDueDate(dueDate);
        taskRepository.save(task);
        return "redirect:/list";
    }
}
