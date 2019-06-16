package cn.itcast;

import cn.itcast.ssm.dao.MemberDao;
import cn.itcast.ssm.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_dao.xml")
public class test1 {
    @Autowired
    private MemberDao memberDao;
    @Test
    public void test2() throws Exception {
        Member memberDaoById = memberDao.findById("E61D65F673D54F68B0861025C69773DB");
        System.out.println(memberDaoById);
    }
}
