package ru.andrey.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.andrey.SpringBoot.model.User;
import ru.andrey.SpringBoot.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.findOne(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }
}
