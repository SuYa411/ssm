package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception{
        return productDao.findAll();
    }

    @Override
    public void save(Product product)throws Exception {
        productDao.save(product);
    }




}
