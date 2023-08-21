package org.launchcode.liftoffgroupproject.controllers;

import org.launchcode.liftoffgroupproject.data.UserRepository;
import org.launchcode.liftoffgroupproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String displayHomepage() {
        return "index";
    }

//    @PostMapping()
//    public String toggleTheme(Principal principal) {
//        User user = userRepository.findByUsername(principal.getName());
//        user.setDarkTheme(user.isDarkTheme());
//        userRepository.save(user);
//        return "index";
//    }
}
