package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {
    //分页订单查询
    List<Orders> findAll(int page,int pageSize) throws Exception;
    //订单详情
    Orders findById(String ordersId) throws Exception;
}
