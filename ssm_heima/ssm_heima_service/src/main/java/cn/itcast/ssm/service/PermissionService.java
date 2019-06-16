package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    //查询资源权限
    List<Permission> findAll() throws Exception;
    //添加资源权限
    void save(Permission pps)throws Exception;
}
