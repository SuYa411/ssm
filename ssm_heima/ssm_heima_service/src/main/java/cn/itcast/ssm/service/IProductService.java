package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductService {

    public List<Product> findAll()throws Exception;

    void save(Product product)throws Exception;


}
