package org.launchcode.liftoffgroupproject.controllers;

import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.data.UserRepository;
import org.launchcode.liftoffgroupproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

   @GetMapping("")
       public String Profile(Model model, User user, Integer taskId) {
       String uName = user.getUsername();
       model.addAttribute("username", "username");
       model.addAttribute("username", userRepository.findByUsername(uName));
       model.addAttribute("tasks", taskRepository.findAll());
//       model.addAttribute("tasks", taskRepository.findById(taskId));
       return "profile";
   }
}
