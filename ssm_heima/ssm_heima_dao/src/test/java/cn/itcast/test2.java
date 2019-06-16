package cn.itcast;

import cn.itcast.ssm.dao.TravellerDao;
import cn.itcast.ssm.domain.Traveller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_dao.xml")
public class test2 {
    @Autowired
    private TravellerDao travellerDao;
    @Test
    public void test1() throws Exception {
        List<Traveller> byOrdersId = travellerDao.findByOrdersId("0E7231DC797C486290E8713CA3C6ECCC");
        for (Traveller traveller : byOrdersId) {
            System.out.println(traveller);
        }
    }
}
