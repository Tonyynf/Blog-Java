package com.descomplica.BlogProject.controllers;

import com.descomplica.BlogProject.models.User;
import com.descomplica.BlogProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")

public class UserController {
    private UserService userService;

    @PostMapping("/save")
    private @ResponseBody User save(@RequestBody User user){
        return userService.save(user);
    }
}
