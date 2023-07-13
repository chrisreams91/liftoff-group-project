package org.launchcode.liftoffgroupproject.controllers;

import org.launchcode.liftoffgroupproject.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationController {

    @Autowired
    UserRepository userRepository;
}
