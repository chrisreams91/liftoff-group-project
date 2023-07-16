package org.launchcode.liftoffgroupproject;

import org.launchcode.liftoffgroupproject.controllers.AuthenticationController;
import org.launchcode.liftoffgroupproject.data.UserRepository;
import org.launchcode.liftoffgroupproject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter implements AsyncHandlerInterceptor {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/login", "/register", "/logout", "/css");

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        response.sendRedirect("/register");
        return false;
    }

    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }
}
