package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll();

    /**
     * 添加信息
     * @param product
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice}, #{productDesc},#{productStatus})")
    void save(Product product);

//根据id查询产品
    @Select("select * from product where id = #{id}")
    public Product findById(String id) throws Exception;



}
