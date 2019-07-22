package com.pg.service;

import com.pg.bean.Department;
import com.pg.bean.TDepartment;
import com.pg.bean.Tree;
import com.pg.common.utils.HrUtils;
import com.pg.common.utils.TreeUtils;
import com.pg.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pg on 2018/1/7.
 */
@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public int addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
        return department.getResult();
    }


    public int addDeps(TDepartment department) {

        /**
         * 新增一个部门
         * 1.传过来父部门的id
         * 2.修改父部门isParent 为 true
         *
         */

        department.setEnabled(1);
       // department.setId(department.getParentId());
        department.setParentId(department.getId());

        //2.修改父部门 isParent 为 1
        TDepartment parentDep =new TDepartment();
        parentDep.setId(department.getId());
        parentDep.setIsParent(1);//有子部门了
        departmentMapper.updateByPrimaryKeySelective(parentDep);
        TDepartment path = departmentMapper.getDepPathById(department);
        //path.setId(null);
        department.setId(null);
        Integer addDeps = departmentMapper.addDeps(department);
        String path1=path.getDepPath()+"."+department.getId();
        department.setDepPath(path1);
        Integer update = departmentMapper.updateByPrimaryKeySelective(department);
        return update;
    }

    public int updateByPrimaryKeySelective(TDepartment department) {

        return departmentMapper.updateByPrimaryKeySelective(department);
    }

    //要在方法上加
    @Transactional(rollbackFor = Exception.class)
    public int deleteDep(Long did) {
        Department department = new Department();
        department.setId(did);
        departmentMapper.deleteDep(department);
        return department.getResult();
    }


    public List<Tree<TDepartment>> getDepByUid(Department department) {
        department.setUid(HrUtils.getCurrentHr().getId());
        List<TDepartment> departments = departmentMapper.getDepByPid(department);

        List<Tree<TDepartment>> trees = new ArrayList<>();
        departments.forEach(department1 -> {
            Tree<TDepartment> tree = new Tree<>();
            tree.setId(department1.getId().toString());
            tree.setParentId(department1.getParentId().toString());
            tree.setName(department1.getName());
            // tree.setIcon(menu.getIcons());
            //tree.setUrl(menu.getUrl());
            tree.setEntityId(department1.getEntityId());
        trees.add(tree);
        });
       // Tree<TDepartment> tMenuTree = TreeUtils.build(trees);
        Tree<TDepartment> departmentTree = TreeUtils.build(trees);
      //  List<Tree<TDepartment>> trees1 = TreeUtils.buildList(trees, "5");
       // System.out.println(trees1.size());

        List<Tree<TDepartment>> children = departmentTree.getChildren();
       // List<Tree<TDepartment>> childrenss = tMenuTree.getChildren();
         return  children;

    }



//    public ListT<TDepartment> getDepByPid(Department department) {
//        return departmentMapper.getDepByPid(department);
//    }

    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }

    public List<TDepartment> getChildrenDep(TDepartment tDepartment) {
        return departmentMapper.getChildrenDep(tDepartment);
    }

}
