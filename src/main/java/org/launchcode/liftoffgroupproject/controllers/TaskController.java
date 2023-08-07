package org.launchcode.liftoffgroupproject.controllers;


import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.models.Task;
import org.launchcode.liftoffgroupproject.models.TaskProgressEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping("add")
    public String displayAddTaskForm(Model model) {
        model.addAttribute("task", new Task());
        //testing
        model.addAttribute("statuses", TaskProgressEnum.values());
        return "add";
    }

    @PostMapping("add")
    public String processAddTaskForm(@ModelAttribute @Valid Task newTask, Model model, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("task", "Add Task");
            LocalDate startDate = newTask.getStartDate();
            LocalDate dueDate = newTask.getDueDate();
            return "add";
        }
        taskRepository.save(newTask);
        return "redirect:/list";
    }

    @GetMapping("delete/{taskId}")
    public String displayDeleteTask(Model model, @PathVariable int taskId) {
        model.addAttribute("task", "Delete Task");
        model.addAttribute("task", taskRepository.findById(taskId));
        return "delete";
    }


    @PostMapping("delete")
    public String processDeleteTaskForm(@RequestParam(required = false) Integer id, String name, String description, LocalDate startDate, LocalDate dueDate) {
        Task deleteTask = taskRepository.findById(id).get();
        deleteTask.setName(name);
        deleteTask.setDescription(description);
        deleteTask.setStartDate(startDate);
        deleteTask.setDueDate(dueDate);
        taskRepository.deleteById(id);

        return "redirect:/list";
    }

//    @GetMapping("edit/{taskId}")
//    public String displayEditForm(Model model , @PathVariable int taskId){
//        model.addAttribute("task", "Edit Task");
//        model.addAttribute("task", taskRepository.findById(taskId));
//        model.addAttribute("statuses", TaskProgressEnum.values());
//        return "edit";
//    }
//
//    @PostMapping("edit/{taskId}")
//    //added taskProgressEnum
//    public String processEditForm(@PathVariable Integer taskId, String name, String description, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, LocalDate dueDate, TaskProgressEnum taskProgressEnum) {
//        Task task = taskRepository.findById(taskId).get();
//        task.setName(name);
//        task.setDescription(description);
//        task.setStartDate(startDate);
//        task.setDueDate(dueDate);
//        task.setTaskProgressEnum(taskProgressEnum);
//        taskRepository.save(task);
//        return "redirect:/list";
//    }
//}

    @GetMapping("edit")
    public String displayEditForm(@RequestParam("taskId") Integer taskId, Model model) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("task", task);
//        model.addAttribute("task", taskRepository.findById(taskId));
        model.addAttribute("statuses", TaskProgressEnum.values());
        return "edit";
    }

    @PostMapping("edit")
    //added taskProgressEnum
    public String processEditForm(@RequestParam(required = false) Integer taskId, @ModelAttribute Task task) {

        Task updatedTask = taskRepository.findById(taskId).orElse(null);

        updatedTask.setName(task.getName());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStartDate(task.getStartDate());
        updatedTask.setDueDate(task.getDueDate());
        updatedTask.setTaskProgressEnum(task.getTaskProgressEnum());
        taskRepository.save(updatedTask);
        return "redirect:/list";
    }
}