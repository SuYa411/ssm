package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;

import java.util.List;

public interface RoleService {
    //查询角色
    List<Role> findAll() throws Exception;
    //添加角色
    void save(Role role) throws Exception;
    //根据ID给角色添加权限
    Role findById(String roleId) throws Exception;
//根据ID给角色添加权限
    List<Permission> findOtherPermission(String roleId) throws Exception ;
//添加权限
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
