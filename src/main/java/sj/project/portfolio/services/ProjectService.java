package sj.project.portfolio.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sj.project.portfolio.dao.mappers.ProjectMapper;
import sj.project.portfolio.dao.models.ProjectModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Slf4j
@Service
public class ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    public List<ProjectModel> getProjects(){
        return projectMapper.selectProjects();
    }

    public ProjectModel getProjectDetail(int seq){
        return projectMapper.selectProjectBySeq(seq);
    }

    public int insertProject(ProjectModel model){
        return projectMapper.insertProject(model);
    }

    public int updateProject(ProjectModel model){
        log.info(model.toString());
        return projectMapper.updateProject(model);
    }

    public LocalDate stringToLocalTime (String dateStr){
        if("".equals(dateStr)){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate result = LocalDate.parse(dateStr, formatter);
        return result;
    }

}
