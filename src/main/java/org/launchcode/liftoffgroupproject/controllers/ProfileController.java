package org.launchcode.liftoffgroupproject.controllers;

import java.util.List;
import java.util.ArrayList;

import org.launchcode.liftoffgroupproject.data.TaskRepository;
import org.launchcode.liftoffgroupproject.data.UserRepository;
import org.launchcode.liftoffgroupproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping(value = "profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AuthenticationController authenticationController;


//    public string assignProfilePicture(String profilePicture) {
//        if (profilePicture.equals("option1")) {
//            return profilePicture.equals("/images/user.png");
//        }›
//        else if (profilePicture.equals("option2")) {
//            return profilePicture.equals("/images/owl.png");
//        }
//
//        else if (profilePicture.equals("option3")) {
//            return profilePicture.equals("/images/panda.png");
//        }
//        else if (profilePicture.equals("option4")) {
//            return profilePicture.equals("/images/zebra.png");
//        }
//        else {
//            return profilePicture.equals("/images/user.png");
//        }
//    }

   @GetMapping("")
       public String Profile(Model model, User user, Integer userId, HttpSession session) {

       Optional<User> result = userRepository.findById(authenticationController.getUserFromSession(session).getId());
       if (result.isPresent()) {
           User loggedUser = result.get();
           model.addAttribute("user", loggedUser);
           model.addAttribute("username", userRepository.findById(loggedUser.getId()));
           model.addAttribute("first name", userRepository.findById(loggedUser.getId()));
           model.addAttribute("first name", authenticationController.getUserFromSession(session).getFirstName());
           model.addAttribute("username", authenticationController.getUserFromSession(session).getUsername());
       }

       model.addAttribute("first name", authenticationController.getUserFromSession(session).getFirstName());
       model.addAttribute("username", authenticationController.getUserFromSession(session).getUsername());


       // get all users
       //this is working to get ALL users
       model.addAttribute("users", userRepository.findAll());

       // don't need
       // get username
//       String uName = user.getUsername();
//       model.addAttribute("username", "username");
//       model.addAttribute("username", userRepository.findByUsername(uName));

       // don't need
//       test
//       Optional<User> individualUser = userRepository.findById(user.getId());
//       model.addAttribute("user", userRepository.findById(user.getId()));

       //get first name
       model.addAttribute("first name", "firstName");

       //list all tasks
       model.addAttribute("tasks", taskRepository.findAll());

       return "profile";
   }


   @GetMapping("picture")
    public String displayChooseProfilePicture(Model model, User user) {
       model.addAttribute("profilePicture", "Edit Profile Picture");
       model.addAttribute("profilePicture", userRepository.findByUsername(user.getUsername()));
       return "picture";
   }

   @PostMapping("picture")
//    public String processChooseProfilePicture(@ModelAttribute("user") User user, String profilePicture, Model model) {
   public String processChooseProfilePicture(User user, String profilePicture, Model model) {
       User currentUser = userRepository.findByUsername(user.getUsername());
       user.setProfilePicture(profilePicture);
       userRepository.save(currentUser);
       return "redirect:/profile";
   }




//   @ModelAttribute("profilePhotoList")
//    public List<String> getProfilePhotoList() {
//       List<String> profilePhotoList = new ArrayList<String>();
//       profilePhotoList.add("/images/user.png");
//       profilePhotoList.add("/images/owl.png");
//       profilePhotoList.add("/images/panda.png");
//       profilePhotoList.add("/images/zebra.png");
//       return profilePhotoList;
//   }


}
