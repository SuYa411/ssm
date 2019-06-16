package cn.itcast;


import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext_*.xml")

public class test4 {
    @Autowired
    private UserDao userDao;
    @Test
    public void test1() throws Exception {
        UserInfo user = new UserInfo();
        user.setUsername("tianliu");
        user.setEmail("tianliu@itcast.cn");
        user.setPassword("333");
        user.setPhoneNum("188888888888");
        user.setStatus(1);
        userDao.save(user);
    }
}
