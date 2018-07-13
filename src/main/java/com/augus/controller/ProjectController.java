package com.augus.controller;

import com.augus.common.StandardResponse;
import com.augus.pojo.Project;
import com.augus.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/getAll")
    public StandardResponse getAllProjectPage(@RequestParam(value="pageNum", defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "1") int pageSize,
                                              @RequestParam(value = "sort", defaultValue = "start_date desc") String sort){
        StandardResponse response = new StandardResponse();
        PageInfo<Project> pageInfo = projectService.findAllProject(pageNum,pageSize,sort);

        return response.success(pageInfo);
    }
}
