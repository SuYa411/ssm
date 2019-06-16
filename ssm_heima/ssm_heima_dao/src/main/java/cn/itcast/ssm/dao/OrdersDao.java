package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import java.util.List;

public interface OrdersDao {
    /**
     *
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.itcast.ssm.dao.ProductDao.findById")),
    })
    public List<Orders> findAll()throws Exception;

    /**
     * 订单详情
     * @return
     */
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.itcast.ssm.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "cn.itcast.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.TravellerDao.findByOrdersId"))
    })
    Orders finById(String ordersId) throws Exception;
}
