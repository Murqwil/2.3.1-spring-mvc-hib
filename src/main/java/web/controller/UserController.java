package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService serviceUser;

    @Autowired
    public UserController(UserService serviceUserParameter) {
        this.serviceUser = serviceUserParameter;
    }

    @GetMapping(value = "")
    public String getUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", serviceUser.getAllUsers());
        return "index";
    }

    @GetMapping("/add")
    public String showAddUserForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        serviceUser.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String showDeleteUserForm() {
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteUsers(@RequestParam int id) {
        serviceUser.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String showUpdateUserForm() {
        return "update";
    }

    @PostMapping("/update")
    public String updateUsers(@RequestParam int id,
                              @RequestParam String name,
                              @RequestParam String lastName,
                              @RequestParam double height,
                              @RequestParam double weight) {
        serviceUser.updateUserById(id, name, lastName, height, weight);
        return "redirect:/users";
    }
}
