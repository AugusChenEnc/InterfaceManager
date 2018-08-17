package com.augus.pojo;

import lombok.Data;

/**
 * 接口管理树形Tree
 * @author Augus
 * @date 2018/8/16 16:55
 */
@Data
public class InterfaceTree {

    private String id;

    private String text;

    private String type;

    private String icon;

    private String parentId;

    private String projectId;

    private String projectName;

}