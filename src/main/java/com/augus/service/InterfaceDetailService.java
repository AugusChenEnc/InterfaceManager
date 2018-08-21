package com.augus.service;

import com.augus.form.InterfaceDetailForm;
import com.augus.mapper.InterfaceDetailMapper;
import com.augus.pojo.InterfaceDetailWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Augus
 * @date 2018/8/20 18:08
 */
@Service
public class InterfaceDetailService {

    @Autowired
    private InterfaceDetailMapper interfaceDetailMapper;

    /**
     * 初始化列表详情
     * @param treeId
     * @return
     */
    public InterfaceDetailWithBLOBs addInitInterfaceDetail(String treeId){
        InterfaceDetailWithBLOBs detailWithBLOBs = new InterfaceDetailWithBLOBs();
        detailWithBLOBs.setId(UUID.randomUUID().toString());
        detailWithBLOBs.setTreeId(treeId);
        return interfaceDetailMapper.insert(detailWithBLOBs) > 0 ? detailWithBLOBs : null;
    }

    /**
     * 查询当前接口的详情
     * @param treeId
     * @return
     */
    public InterfaceDetailForm findInterfaceDetailByTreeId(String treeId) {
        InterfaceDetailForm form = new InterfaceDetailForm();
        InterfaceDetailWithBLOBs detailWithBLOBs = interfaceDetailMapper.findByTreeId(treeId);
        if (detailWithBLOBs == null) {
            detailWithBLOBs = addInitInterfaceDetail(treeId);
        }

        form.setId(detailWithBLOBs.getId());
        form.setTreeId(detailWithBLOBs.getTreeId());
        form.setReqAddress(detailWithBLOBs.getReqAddress());
        form.setReqAddressExplain(detailWithBLOBs.getReqAddressExplain());
        form.setReqType(detailWithBLOBs.getReqType());
        form.setReqData(detailWithBLOBs.getReqData());
        form.setReqDataExplain(detailWithBLOBs.getReqDataExplain());
        form.setRespData(detailWithBLOBs.getRespData());
        form.setReqDataExplain(detailWithBLOBs.getReqDataExplain());
        form.setRemark(detailWithBLOBs.getRemark());

        return form;
    }

    public boolean amendInterfaceDetail(InterfaceDetailForm detailForm) {

        InterfaceDetailWithBLOBs detailWithBLOBs = new InterfaceDetailWithBLOBs();
        detailWithBLOBs.setId(detailForm.getId());
        detailWithBLOBs.setTreeId(detailForm.getTreeId());
        detailWithBLOBs.setReqAddress(detailForm.getReqAddress());
        detailWithBLOBs.setReqAddressExplain(detailForm.getReqAddressExplain());
        detailWithBLOBs.setReqType(detailForm.getReqType());
        detailWithBLOBs.setReqData(detailForm.getReqData());
        detailWithBLOBs.setReqDataExplain(detailForm.getReqDataExplain());
        detailWithBLOBs.setRespData(detailForm.getRespData());
        detailWithBLOBs.setReqDataExplain(detailForm.getReqDataExplain());
        detailWithBLOBs.setRemark(detailForm.getRemark());
        return interfaceDetailMapper.updateByPrimaryKeyWithBLOBs(detailWithBLOBs) > 0;
    }
}
