package com.augus.service;

import com.augus.form.ProjectForm;
import com.augus.mapper.ProjectMapper;
import com.augus.pojo.Project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 项目管理服务类
 * @author Augus
 * @date 2018/7/9 18:06
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    public PageInfo<Project> findAllProject(ProjectForm projectForm){

        PageHelper.startPage(projectForm.getPageNum(), projectForm.getPageSize(), projectForm.getSort());
        List<Project> projectList = projectMapper.findAllProject(projectForm.getName(), projectForm.getStartDate(),
                projectForm.getEndDate() ,projectForm.getStatus());

        return new PageInfo<>(projectList);
    }

    public int insertProject(Project project) {
        project.setId(UUID.randomUUID().toString());
        return projectMapper.insert(project);
    }


}
