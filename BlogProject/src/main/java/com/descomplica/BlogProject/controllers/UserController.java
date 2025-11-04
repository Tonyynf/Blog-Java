package com.descomplica.BlogProject.controllers;

import com.descomplica.BlogProject.models.User;
import com.descomplica.BlogProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    private @ResponseBody User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping(path = "/get")
    private @ResponseBody User get(@RequestParam final Long id){
        return userService.get(id);
    }

    @GetMapping(path = "/getAll")
    private @ResponseBody List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping(path = "/update")
    private @ResponseBody User update(@RequestParam final Long id, @RequestBody User user){
        return userService.update(id, user);
    }

    @DeleteMapping(path = "/delete")
    private ResponseEntity<?> delete(@RequestParam final Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/")
        public @ResponseBody String authentication(){
            return "Hello World";
        }




}
