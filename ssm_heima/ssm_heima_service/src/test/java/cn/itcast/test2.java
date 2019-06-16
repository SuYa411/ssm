package cn.itcast;

import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.OrdersService;
import cn.itcast.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext_*.xml")
public class test2 {
    @Autowired
    private UserService userService;
    @Test
    public void test1() throws Exception {
        List<UserInfo> all = userService.findAll();
        for (UserInfo userInfo : all) {
            System.out.println(userInfo);
        }
    }
}
