package com.augus.mapper;

import com.augus.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * User Mapper Dao
 * @author Augus
 * @date 2018/07/06
 */
@Repository
@Mapper
public interface UsersMapper {

    /**
     * 按照key删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(Users record);

    /**
     * 插入记录（判断每一项都不为空）
     * @param record
     * @return
     */
    int insertSelective(Users record);

    /**
     * 根据id 查询记录
     * @param id
     * @return
     */
    Users selectByPrimaryKey(String id);

    /**
     * 根据用户号和密码查询用户
     * @param account
     * @param password
     * @return
     */
    Users selectByAccountAndPassword(@Param("account") String account,@Param("password") String password);

    /**
     * 按照id进行数据更新（判空）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * 按照id进行数据更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Users record);

}