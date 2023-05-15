package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/show/{id}")
    public String showUser(ModelMap model, @PathVariable(value = "id", required = false) Integer id) {
        model.addAttribute("user", userService.showUser(id));
        return "show";
    }

    @GetMapping("/users/save")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "saveUser";
    }

    @PostMapping("/users/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/update/{id}")
    public String updateUser(@PathVariable(value = "id", required = false) Integer id, ModelMap model) {
        model.addAttribute("user", userService.showUser(id));
        return "update";
    }

    @PatchMapping(value = "users/update")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable(value = "id", required = false) Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
