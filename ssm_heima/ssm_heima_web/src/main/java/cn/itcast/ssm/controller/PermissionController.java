package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService ps;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        List<Permission> permissionList = ps.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission_list");
        return mv;
    }
    //添加资源权限
    @RequestMapping("/save.do")
    public String save(Permission pps)throws Exception{
        ps.save(pps);
        return "redirect:findAll.do";
    }
}
