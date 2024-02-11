package sj.project.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index (){
        return "index";
    }

    @GetMapping("/why")
    public String why (){
        return "why";
    }

    @GetMapping("/team")
    public String team (){
        return "team";
    }

    @GetMapping("/setting")
    public String setting (){
        return "setting";
    }
}
