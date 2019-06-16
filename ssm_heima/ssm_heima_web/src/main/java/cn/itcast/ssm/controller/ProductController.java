package cn.itcast.ssm.controller;


import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
    @RequestMapping("/product")
public class ProductController {

    /**
     * 查询所有产品
     */
    @Autowired
    private IProductService iproductService;
    @RequestMapping("/find.do")
    public String findAll(Model model) throws Exception {
        List<Product> all = iproductService.findAll();
        model.addAttribute("productList",all);
        return "product_list1";
    }

    /**
     * 添加产品
     * @param product
     * @return
     */
    @RequestMapping("/save.do")
    public String save(Product product)throws Exception{
        iproductService.save(product);
        return "redirect:find.do";
    }

}
