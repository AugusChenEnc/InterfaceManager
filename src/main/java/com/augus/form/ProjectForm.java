package com.augus.form;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Augus
 * @date 2018/7/13 18:19
 */
@Data
public class ProjectForm extends PageForm{

    /**
     * search Content
     */
    private String name;
    private String startDate;
    private String endDate;
    private Integer status;

}
