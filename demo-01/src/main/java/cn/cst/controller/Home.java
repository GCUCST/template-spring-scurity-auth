package cn.cst.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Home {

    @GetMapping
    public String home(  Model model) {
        model.addAttribute("welcomeMsg","你好呀");
        return "home";
    }


    @PreAuthorize("hasAuthority('p3')")
    @GetMapping("/info")
    public String info(  Model model) {
        model.addAttribute("welcomeMsg","info...");
        return "home";
    }

}
