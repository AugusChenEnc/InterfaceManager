package com.augus.controller;


import com.alibaba.fastjson.JSON;
import com.augus.common.StandardResponse;
import com.augus.form.ProjectForm;
import com.augus.pojo.Project;
import com.augus.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 项目管理控制器
 * @author Augus
 * @date 2018/7/9 17:32
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public StandardResponse getAllProjectPage(@RequestBody ProjectForm projectForm){
        StandardResponse response = new StandardResponse();
        PageInfo<Project> pageInfo = projectService.findAllProject(projectForm);
        return response.success(pageInfo);
    }

    @RequestMapping(value = "/saveProject", method = RequestMethod.POST)
    public StandardResponse saveProject(@RequestBody Project project) {
        StandardResponse response = new StandardResponse();
        int result = projectService.insertProject(project);
        return response.success(result > 0);
    }

    @RequestMapping(value = "/updateProject", method = RequestMethod.PUT)
    public StandardResponse updateProject(@RequestBody Project project) {
        StandardResponse response = new StandardResponse();
        int result = projectService.amendProject(project);
        return response.success(result > 0);
    }

    @RequestMapping(value = "/removeProject/{id}", method = RequestMethod.DELETE)
    public StandardResponse removeProject(@PathVariable("id") String id) {
        StandardResponse response = new StandardResponse();
        int result = projectService.removeProject(id);
        if (result > 0) {
            return response.success(true);
        }
        return response.failure("remove project error");
    }

}
