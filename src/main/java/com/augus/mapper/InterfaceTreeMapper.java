package com.augus.mapper;

import com.augus.pojo.InterfaceTree;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 接口树形管理
 * @author Augus
 * @date 2018/8/16
 */
@Mapper
@Repository
public interface InterfaceTreeMapper {

    int deleteByPrimaryKey(String id);

    int insert(InterfaceTree record);

    int insertSelective(InterfaceTree record);

    InterfaceTree selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InterfaceTree record);

    int updateByPrimaryKey(InterfaceTree record);

    InterfaceTree findTreeByProjectId(String projectId);

    List<InterfaceTree> findTreeByParentId(String parentId);
}