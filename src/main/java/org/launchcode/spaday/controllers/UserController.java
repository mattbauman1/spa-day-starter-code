package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        UserData.add(user);
        if(user.getPassword().equals(verify)) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("users", UserData.getAll());
            return "/user/index";
        }
        else {
            model.addAttribute("error", " Password mismatch, please try again!");
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "/user/add";
        }
    }

    @GetMapping("detail/{id}")
    public String getUserDetail(Model model, @PathVariable int id) {
        model.addAttribute("user", UserData.getById(id));
        return "/user/detail";
    }
}
