package org.launchcode.liftoffgroupproject.controllers;


import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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
       return "redirect:/list";
    }

    @GetMapping("delete/{taskId}")
    public String displayDeleteTask(Model model, @PathVariable int taskId){
        model.addAttribute("task", "Delete Task");
        model.addAttribute("task", taskRepository.findById(taskId));
        return"delete";
    }


    @PostMapping("delete")
    public String processDeleteTaskForm(Integer id, String name, String description, LocalDate startDate, LocalDate dueDate){
        Task deleteTask = taskRepository.findById(id).get();
        deleteTask.setName(name);
        deleteTask.setDescription(description);
        deleteTask.setStartDate(startDate);
        deleteTask.setDueDate(dueDate);
        taskRepository.deleteById(id);

        return"redirect:/list";
    }

    @GetMapping("edit/{taskId}")
    public String displayEditForm(Model model , @PathVariable int taskId){
        model.addAttribute("task", "Edit Task");
        model.addAttribute("task", taskRepository.findById(taskId));
        return "edit";
    }

    @PostMapping("edit")
    public String processEditForm(Integer id, String name, String description, LocalDate startDate, LocalDate dueDate) {
        Task task = taskRepository.findById(id).get();
        task.setName(name);
        task.setDescription(description);
        task.setStartDate(startDate);
        task.setDueDate(dueDate);
        taskRepository.save(task);
        return "redirect:/list";
    }
}
