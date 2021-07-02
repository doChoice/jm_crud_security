package net.stupkin.jmcources.controller;

import net.stupkin.jmcources.model.Role;
import net.stupkin.jmcources.model.User;
import net.stupkin.jmcources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;


    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "users/show-all-users";
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        List<Role> allRoles = userService.getAllRoles();
        model.addAttribute("allRoles", allRoles);
        return "users/new-user";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @RequestParam (value ="roles", required = false) Long[] rolesId) {

        Set<Role> roles = new HashSet<>();
        for (Long id : rolesId) {
            roles.add(userService.getRoleById(id));
        }
        user.setRoles(roles);
        if (bindingResult.hasErrors()) {
            return "users/new-user";
        }
        userService.saveUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        List<Role> allRoles = userService.getAllRoles();
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("allRoles", allRoles);

        return "users/edit-user";
    }


    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @RequestParam (value ="roles", required = false) Long[] rolesId){


        Set<Role> roles = new HashSet<>();
        if(rolesId != null) {
            for (Long id : rolesId) {
                roles.add(userService.getRoleById(id));
            }
            user.setRoles(roles);
        } else {
            user.setRoles(userService.getUserById(user.getId()).getRoles());
        }

        if (bindingResult.hasErrors()) {
            return "users/edit-user";
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
