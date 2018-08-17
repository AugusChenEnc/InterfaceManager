package com.augus.controller;

import com.augus.annotation.IgnoreSecurity;
import com.augus.common.StandardResponse;
import com.augus.form.InterfaceTreeForm;
import com.augus.service.InterfaceTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Augus
 * @date 2018/8/16 17:12
 */
@RestController
@RequestMapping(value = "/interfaceTree")
public class InterfaceTreeController {

    @Autowired
    private InterfaceTreeService interfaceTreeService;

    @RequestMapping(value = "/{projectId}/getTree", method = RequestMethod.GET)
    public StandardResponse getTree(@PathVariable("projectId") String projectId) {
        StandardResponse response = new StandardResponse();
        InterfaceTreeForm treeForm = interfaceTreeService.findInterfaceTreeByProjectId(projectId);
        return response.success(treeForm);
    }

    @RequestMapping(value = "/addTreeStructure", method = RequestMethod.POST)
    public StandardResponse addTreeStructure(@RequestBody InterfaceTreeForm treeForm) {
        StandardResponse response = new StandardResponse();
        boolean flag = interfaceTreeService.addTreeStructure(treeForm);
        return response.success(flag);
    }

    @RequestMapping(value = "/amendTreeStructure", method = RequestMethod.PUT)
    public StandardResponse amendTreeStructure(@RequestBody InterfaceTreeForm treeForm) {
        StandardResponse response = new StandardResponse();
        boolean flag = interfaceTreeService.amendTreeStructure(treeForm);
        return response.success(flag);
    }

    @RequestMapping(value = "/{projectId}/deleteTreeStructure", method = RequestMethod.DELETE)
    public StandardResponse deleteTreeStructure(@PathVariable("projectId") String projectId) {
        StandardResponse response = new StandardResponse();
        boolean flag = interfaceTreeService.deleteTreeStructure(projectId);
        return response.success(flag);
    }

}
