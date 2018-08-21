package com.augus.mapper;

import com.augus.pojo.InterfaceDetail;
import com.augus.pojo.InterfaceDetailWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Augus
 * @date 2018/08/20
 */
@Mapper
@Repository
public interface InterfaceDetailMapper {

    int deleteByPrimaryKey(String id);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insert(InterfaceDetailWithBLOBs record);

    int insertSelective(InterfaceDetailWithBLOBs record);

    InterfaceDetailWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(InterfaceDetailWithBLOBs record);

    /**
     * 根据id更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(InterfaceDetailWithBLOBs record);

    int updateByPrimaryKey(InterfaceDetail record);

    /**
     * 根据树形的id查询到对应的值
     * @param treeId
     * @return
     */
    InterfaceDetailWithBLOBs findByTreeId(String treeId);
}