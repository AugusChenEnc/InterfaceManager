package com.augus.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 项目管理实体类
 * @author Augus
 * @date 2018/7/9 17:32
 */
@Data
public class Project {

    /**
     * 项目编号
     */
    private String id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 所属区域
     */
    private String area;

    /**
     * 完成状态
     */
    private Integer status;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date endDate;

    /**
     * 项目描述
     */
    private String description;

}