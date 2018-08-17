package com.augus.service;

import com.augus.form.ProjectForm;
import com.augus.mapper.ProjectMapper;
import com.augus.pojo.Project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * select all project records and no paging and unconditional
     * @return
     */
    public List<List<Project>> findAllProjectNoPage(){

        List<Project> projectList = projectMapper.findAllProject(null, null, null ,null);
        List<List<Project>> multipleLists = new ArrayList<>();

        int count = 0;
        List<Project> splitLists = null;
        for (Project project : projectList) {
            if (count % 5 == 0) {
                splitLists = new ArrayList<>();
                multipleLists.add(splitLists);
            }
            splitLists.add(project);
            count++;
        }
        return multipleLists;
    }

    /**
     * select all project recodes paging and condition
     * @param projectForm
     * @return
     */
    public PageInfo<Project> findAllProject(ProjectForm projectForm){

        PageHelper.startPage(projectForm.getPageNum(), projectForm.getPageSize(), projectForm.getSort());
        List<Project> projectList = projectMapper.findAllProject(projectForm.getName(), projectForm.getStartDate(),
                projectForm.getEndDate() ,projectForm.getStatus());

        return new PageInfo<>(projectList);
    }

    public Project findProjectById(String id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    public int insertProject(Project project) {
        project.setId(UUID.randomUUID().toString());
        return projectMapper.insert(project);
    }

    public int amendProject(Project project) {
        return projectMapper.updateByPrimaryKeyWithBLOBs(project);
    }

    public int removeProject(String id) {
        return projectMapper.deleteByPrimaryKey(id);
    }
}
