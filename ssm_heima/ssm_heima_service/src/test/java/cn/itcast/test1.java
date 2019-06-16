package cn.itcast;

import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext_*.xml")
public class test1 {
    @Autowired
    private OrdersService ordersService;
    @Test
    public void test1() throws Exception {
        Orders byId = ordersService.findById("0E7231DC797C486290E8713CA3C6ECCC");
        System.out.println(byId);
    }
}
