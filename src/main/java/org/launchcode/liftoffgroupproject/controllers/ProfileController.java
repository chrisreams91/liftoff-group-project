package org.launchcode.liftoffgroupproject.controllers;


import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.data.UserRepository;
import org.launchcode.liftoffgroupproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AuthenticationController authenticationController;



   @GetMapping("")
       public String Profile(Model model, HttpSession session, String username, String firstName) {

       User user = authenticationController.getUserFromSession(session);
       model.addAttribute("first name", user.getFirstName());
       model.addAttribute("username", user.getUsername());


       // get all users
       //this is working to get ALL users
       model.addAttribute("users", userRepository.findAll());


       //list all tasks
       model.addAttribute("tasks", taskRepository.findAll());

       return "profile";
   }


   @GetMapping("picture")
    public String displayChooseProfilePicture(Model model, User user) {
       model.addAttribute("profilePicture", "Edit Profile Picture");
       return "picture";
   }

   @PostMapping("picture")
   public String processChooseProfilePicture(HttpSession session, String profilePicture) {
       User user = authenticationController.getUserFromSession(session);
       user.setProfilePicture(profilePicture);
       userRepository.save(user);
       return "redirect:/profile";
   }
}
