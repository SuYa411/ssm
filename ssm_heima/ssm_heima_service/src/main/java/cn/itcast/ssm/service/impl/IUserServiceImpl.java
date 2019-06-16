package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录认证
 */
@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;

            try {
                userInfo = userDao.findByUsername(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //处理自己 的用户对象封装成UserDetails
            User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true, getAuthority(userInfo.getRoles()));

            return user;

    }
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> authoritys = new ArrayList<>();
        for (Role role : roles) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return authoritys;
    }


}
