package cn.itcast.ssm.controller;


import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll.do")
    //@RolesAllowed("USER")     //JSR-250注解
    //分页订单查询
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") int pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders_page_list");
        return modelAndView;
    }

    //订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders", orders);
        mv.setViewName("orders_show");
        System.out.println(orders);
        return mv;
    }
}
