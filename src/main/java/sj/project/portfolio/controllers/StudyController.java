package sj.project.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudyController {
    @GetMapping("/study")
    public String study() {
        return "about";
    }
    
}
