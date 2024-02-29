package sj.project.portfolio.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sj.project.portfolio.dao.models.ProjectModel;
import sj.project.portfolio.models.ResponseModel;
import sj.project.portfolio.services.ProjectService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Controller
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @GetMapping("/project")
    public String project() {
        return "project";
    }

    @GetMapping("/project/setting")
    public String projectSetting(){
        return "project_setting";
    }

    @GetMapping("/project/list")
    public @ResponseBody ResponseModel<ProjectModel> getProjects (){

        return new ResponseModel<>(true, "정상적을 조회되었습니다", null, projectService.getProjects());
    }

    @GetMapping("/project/get/{seq}")
    public @ResponseBody ResponseModel<ProjectModel> getProjectDetail(@PathVariable("seq") int seq){
        return new ResponseModel<>(true, "정상적으로 조회되었습니다", projectService.getProjectDetail(seq), null);
    }

    @PostMapping("/project/insert")
    public @ResponseBody int insertProject(ProjectModel model){
        return projectService.insertProject(model);
    }

    @PostMapping("/project/update")
    public @ResponseBody ResponseModel<ProjectModel> updateProject(ProjectModel model){
        //project name 중복체크
        model.setProjectStartDt(projectService.stringToLocalTime(model.getProjectStartDtStr()));
        model.setProjectEndDt(projectService.stringToLocalTime(model.getProjectEndDtStr()));
        model.setUpdateDt(LocalDateTime.now());
        projectService.updateProject(model);
        return  new ResponseModel<>(true, "정상적으로 저장되었습니다", null, null);
    }

    
}
