package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;

import java.util.List;

public interface UserService {
    //查询用户
    public List<UserInfo> findAll() throws Exception;
    //添加用户
    public  void save(UserInfo user) throws Exception;
    //根据用户id查询用户详情
   public UserInfo findById(String id) throws Exception;
    //根据用户id添加角色
    List<Role> findOtherRole(String id)throws Exception;
//根据id给用户添加角色
    void addRoleToUser(String userId, String[] roleIds);
}
