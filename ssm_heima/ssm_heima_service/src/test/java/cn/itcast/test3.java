package cn.itcast;

import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.IProductService;
import cn.itcast.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext_*.xml")
public class test3 {
    @Autowired
    private UserService userService;
    @Test
    public void test1() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("tianliu");
        userInfo.setEmail("tianliu@itcast.cn");
        userInfo.setPassword("333");
        userInfo.setPhoneNum("188888888888");
        userInfo.setStatus(1);
       userService.save(userInfo);
    }
}
