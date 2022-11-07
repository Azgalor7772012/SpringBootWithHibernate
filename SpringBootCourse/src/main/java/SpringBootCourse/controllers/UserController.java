package SpringBootCourse.controllers;

import SpringBootCourse.models.User;
import SpringBootCourse.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("users")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.showUsers());
        return "showAllUsers";
    }

    @GetMapping("/user/{id}")
    public String showOneUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showOneUser(id));
        return "showOneUser";
    }

    @GetMapping("/user/edit/{id}")
    public String getEditUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.showOneUser(id));
        return "editUser";
    }

    @PatchMapping("/user/edit/{id}")
    public String patchEditUser(@ModelAttribute("user") User user,
                                @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/users";
    }


    @DeleteMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/newUser")
    public String getNewUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/newUser")
    public String postNewUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
}
