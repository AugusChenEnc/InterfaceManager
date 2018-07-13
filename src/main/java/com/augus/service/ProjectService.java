package com.augus.service;

import com.augus.mapper.ProjectMapper;
import com.augus.pojo.Project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目管理服务类
 * @author Augus
 * @date 2018/7/9 18:06
 */
@Service
public class ProjectService {

    @Autowired
    @Resource
    private ProjectMapper projectMapper;

    public PageInfo<Project> findAllProject(int pageNum, int pageSize, String sort){
        PageHelper.startPage(pageNum, pageSize, sort);
        List<Project> projectList = projectMapper.findAllProject();

        return new PageInfo<>(projectList);
    }

}
