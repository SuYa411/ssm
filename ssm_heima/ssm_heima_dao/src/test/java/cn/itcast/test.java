package cn.itcast;

import cn.itcast.ssm.dao.MemberDao;
import cn.itcast.ssm.dao.OrdersDao;
import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.domain.Member;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_dao.xml")
public class test {
    @Autowired
    private ProductDao productDao;

    @Test
    public void test1(){
        List<Product> all = productDao.findAll();
        for (Product product : all) {
            System.out.println(product);
        }
    }



}
