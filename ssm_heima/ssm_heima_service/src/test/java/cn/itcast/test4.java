package cn.itcast;

import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
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
    private SysLogService sysLogService;
    @Test
    public void test1() throws Exception {
        List<SysLog> all = sysLogService.findAll();
        for (SysLog sysLog : all) {
            System.out.println(sysLog);
        }
    }
}

