package com.augus.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Tree Root
 * @author Augus
 * @date 2018/8/16 17:03
 */
@Data
public class InterfaceTreeForm {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String text;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String icon;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String parentId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<InterfaceTreeForm> children;

}
