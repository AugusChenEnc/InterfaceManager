package com.augus.service;

import com.augus.form.InterfaceTreeForm;
import com.augus.mapper.InterfaceTreeMapper;
import com.augus.pojo.InterfaceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口管理树形服务
 * @author Augus
 * @date 2018/8/16 16:56
 */
@Service
public class InterfaceTreeService {

    @Autowired
    private InterfaceTreeMapper interfaceTreeMapper;

    public InterfaceTreeForm findInterfaceTreeByProjectId(String projectId){
        System.out.println(projectId);
        InterfaceTree tree = interfaceTreeMapper.findTreeByProjectId(projectId);
        return treeDataGenerate(tree);
    }

    /**
     * 递归生成Tree (这是第一种办法：一次全部生成)
     * @return
     */
    public InterfaceTreeForm treeDataGenerate(InterfaceTree interfaceTree){
        if (interfaceTree == null || interfaceTree.getId() == null) {
            return new InterfaceTreeForm();
        }

        InterfaceTreeForm rootTree = new InterfaceTreeForm();
        rootTree.setId(interfaceTree.getId());
        rootTree.setText(interfaceTree.getProjectName());
        rootTree.setType(interfaceTree.getType());
        rootTree.setIcon(interfaceTree.getIcon());

        treeRepetition(rootTree, rootTree.getId());
        return rootTree;
    }

    /**
     * 递归生成子目录
     * @param rootTreeForm
     * @param id
     * @return
     */
    public void treeRepetition(InterfaceTreeForm rootTreeForm, String id) {
        List<InterfaceTree> treeList =  interfaceTreeMapper.findTreeByParentId(id);
        List<InterfaceTreeForm> childrenList = new ArrayList<>();
        for (InterfaceTree tree : treeList) {
            if (tree == null || tree.getId() == null) {
                continue;
            }
            InterfaceTreeForm childrenTree = new InterfaceTreeForm();
            childrenTree.setId(tree.getId());
            childrenTree.setText(tree.getText());
            childrenTree.setType(tree.getType());
            childrenTree.setIcon(tree.getIcon());
            childrenList.add(childrenTree);

            treeRepetition(childrenTree, tree.getId());
        }
        if (!childrenList.isEmpty() && childrenList.size() >= 1 ) {
            rootTreeForm.setChildren(childrenList);
        }
    }

}
