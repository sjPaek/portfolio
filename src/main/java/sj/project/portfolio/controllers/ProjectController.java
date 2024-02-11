package sj.project.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProjectController {
    
    @GetMapping("/project")
    public String project() {
        return "project";
    }

    
    
}
