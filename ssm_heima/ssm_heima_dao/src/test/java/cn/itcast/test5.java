package cn.itcast;

import cn.itcast.ssm.dao.SysLogDao;
import cn.itcast.ssm.domain.SysLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext_*.xml")
public class test5 {
    @Autowired
    private SysLogDao sysLogDao;
    @Test
    public void test1() throws Exception {
        List<SysLog> all = sysLogDao.findAll();
        for (SysLog sysLog : all) {
            System.out.println(sysLog);
        }
    }
}
