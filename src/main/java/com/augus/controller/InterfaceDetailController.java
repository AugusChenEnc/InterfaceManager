package com.augus.controller;

import com.augus.common.StandardResponse;
import com.augus.form.InterfaceDetailForm;
import com.augus.service.InterfaceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Augus
 * @date 2018/8/20 18:41
 */
@RestController
@RequestMapping(value = "/interfaceDetail")
public class InterfaceDetailController {

    @Autowired
    private InterfaceDetailService interfaceDetailService;

    @RequestMapping(value = "/{treeId}/findInterfaceDetail")
    public StandardResponse findInterfaceDetailByTreeId(@PathVariable("treeId") String treeId) {
        StandardResponse response = new StandardResponse();
        InterfaceDetailForm form = interfaceDetailService.findInterfaceDetailByTreeId(treeId);
        return response.success(form);
    }

    @RequestMapping(value = "/amendInterfaceDetail", method =  RequestMethod.PUT)
    public StandardResponse amendInterfaceDetail(@RequestBody InterfaceDetailForm detailForm) {
        StandardResponse response = new StandardResponse();
        boolean flag = interfaceDetailService.amendInterfaceDetail(detailForm);
        return response.success(flag);
    }

}
