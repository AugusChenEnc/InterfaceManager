package com.augus.controller;

import com.augus.annotation.IgnoreSecurity;
import com.augus.common.StandardResponse;
import com.augus.form.InterfaceTreeForm;
import com.augus.service.InterfaceTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Augus
 * @date 2018/8/16 17:12
 */
@RestController
@RequestMapping(value = "/interfaceTree")
public class InterfaceTreeController {

    @Autowired
    private InterfaceTreeService interfaceTreeService;

    @IgnoreSecurity
    @RequestMapping(value = "/{projectId}/getTree", method = RequestMethod.GET)
    public StandardResponse getTree(@PathVariable("projectId") String projectId) {
        StandardResponse response = new StandardResponse();
        InterfaceTreeForm treeForm = interfaceTreeService.findInterfaceTreeByProjectId(projectId);
        return response.success(treeForm);
    }

}
