package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.OrdersDao;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page,int pageSize) throws Exception {
        //pageNum显示页码
        //pageSize显示每页条数
        //分页查询工具
        /**
         * pageNum显示页码
         * pageSize显示每页条数
         * 分页查询工具
         */
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }

    /**
     * 订单详情
     * @param ordersId
     * @return
     */
    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.finById(ordersId);
    }
}
