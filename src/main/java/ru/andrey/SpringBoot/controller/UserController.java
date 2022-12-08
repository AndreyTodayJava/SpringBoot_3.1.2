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
    public UserController(UserService userServiceImp) {
        this.userService = userServiceImp;
    }


    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute("user") User user) {
        userService.updateUser(user, id);
        return "redirect:/users";
    }
}
