package com.augus.form;

import lombok.Data;

/**
 * @author Augus
 * @date 2018/7/19 18:10
 */
@Data
public class PageForm {

    /**
     * page Content
     */
    private Integer pageNum;
    private Integer pageSize;
    private String sort;

    public Integer getPageNum() {
        if (this.pageNum == null || this.pageNum < 1) {
            this.pageNum = 1;
        }
        return pageNum;
    }

    public Integer getPageSize() {
        if (this.pageSize == null || this.pageSize < 1) {
            this.pageSize = 10;
        }
        return pageSize;
    }

}
