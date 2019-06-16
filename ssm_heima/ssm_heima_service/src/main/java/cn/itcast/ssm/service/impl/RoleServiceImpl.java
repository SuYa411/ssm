package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.RoleDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.service.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    //查询角色
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }
    //添加角色
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }
    //根据ID给角色添加权限
    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }
    //根据ID给角色添加权限
    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }
    //添加权限
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception{
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
