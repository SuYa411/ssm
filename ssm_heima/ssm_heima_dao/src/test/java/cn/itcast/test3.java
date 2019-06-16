package cn.itcast;


import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.dao.UserDao;
import cn.itcast.ssm.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_dao.xml")

public class test3 {
    @Autowired
    private UserDao userDao;
    @Test
    public void test1() throws Exception {
        List<UserInfo> all = userDao.findAll();
        for (UserInfo userInfo : all) {
            System.out.println(userInfo);
        }
    }
}
