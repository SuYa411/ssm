package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.PermissionDao;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    //查询权限
    @Override
    public List<Permission> findAll() throws Exception{
        return permissionDao.findAll();
    }
    //添加资源权限
    @Override
    public void save(Permission pps) throws Exception {
        permissionDao.save(pps);
    }
}
