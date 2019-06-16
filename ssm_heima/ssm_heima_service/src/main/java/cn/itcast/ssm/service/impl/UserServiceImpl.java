package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //查询用户
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    //添加用户
    @Override
    public void save(UserInfo user)throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         userDao.save(user);
    }
    //根据用户id查询用户详情
    @Override
    public UserInfo findById(String id) throws Exception{
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRole(String id) throws Exception {
        return userDao.findOtherRole(id);
    }
    //根据id给用户添加角色


    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }

    }
}
