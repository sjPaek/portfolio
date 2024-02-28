package sj.project.portfolio.dao.mappers;

import org.apache.ibatis.annotations.Mapper;
import sj.project.portfolio.dao.models.ProjectModel;

import java.util.List;

@Mapper
public interface ProjectMapper {
    List<ProjectModel> selectProjects();

    ProjectModel selectProjectBySeq(int seq);

    int insertProject(ProjectModel model);
    int updateProject(ProjectModel model);
}
