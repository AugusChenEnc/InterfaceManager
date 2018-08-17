package com.augus.mapper;

import com.augus.pojo.Project;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目管理映射类
 * @author Augus
 * @date 2018/7/9 17:32
 */
@Mapper
@Repository
public interface ProjectMapper {

    /**
     * deleteByPrimaryKey
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * insert
     * @param record
     * @return
     */
    int insert(Project record);

    /**
     * insertSelective
     * @param record
     * @return
     */
    int insertSelective(Project record);

    /**
     * selectByPrimaryKey
     * @param id
     * @return
     */
    Project selectByPrimaryKey(String id);

    /**
     * updateByPrimaryKeySelective
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Project record);

    /**
     * updateByPrimaryKey
     * @param record
     * @return
     */
    int updateByPrimaryKey(Project record);

    /**
     * 查询所有的项目
     * @param name
     * @param startDate
     * @param endDate
     * @param status
     * @return
     */
    List<Project> findAllProject(@Param("name") String name, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("status") Integer status);
}