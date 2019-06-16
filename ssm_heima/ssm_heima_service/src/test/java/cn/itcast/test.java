package cn.itcast;

import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext_*.xml")
public class test {
    @Autowired
    private IProductService iProductService;
    @Test
    public void test1() throws Exception {
        List<Product> all = iProductService.findAll();
        for (Product product : all) {
            System.out.println(product);
        }
    }
}
