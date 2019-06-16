package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    //@Secured("ROLE_ADMIN")    //@Secured注解
    private ModelAndView findAll()throws Exception{
        List<Role> roleList = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList",roleList);
        mv.setViewName("role_list");
        return mv;
    }

    //添加角色
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        roleService.save(role);
        return "redirect:findAll.do";
    }

    //根据roleId查询role,并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception{
            Role role = roleService.findById(roleId);
            List<Permission> permissionList = roleService.findOtherPermission(roleId);
            ModelAndView mv = new ModelAndView();
            mv.addObject("role",role);
            mv.addObject("permissionList",permissionList);
            mv.setViewName("role_permission_add");
            return mv;
    }
    //添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name ="permissionId",required = true)String[] permissionIds) throws Exception{
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }
    //根据角色id查询资源权限
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id") String roleId) throws Exception{
        Role role = roleService.findById(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.setViewName("role_show");
        return mv;
    }
}
