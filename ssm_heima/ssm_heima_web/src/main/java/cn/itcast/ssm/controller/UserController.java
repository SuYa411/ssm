package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.IDN;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //查询用户
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<UserInfo> userList = userService.findAll();

        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", userList);
        mv.setViewName("user_list");
        return mv;
    }

    //添加用户
    @RequestMapping("/save.do")
    public String save(UserInfo user) throws Exception {
        userService.save(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id)throws Exception{
        UserInfo userInfo = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",userInfo);
        modelAndView.setViewName("user_show1");
        return modelAndView;

    }
    //根据用户id添加角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String id) throws Exception{
        //根据用户id查询用户
        UserInfo user = userService.findById(id);
        //根据用户id查询可以添加角色用户
      List<Role> roleList =   userService.findOtherRole(id);
      ModelAndView mv = new ModelAndView();
      mv.addObject("user",user);
      mv.addObject("roleList",roleList);
      mv.setViewName("user_role_add");
      return mv;
    }


    //根据id给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds) throws Exception{
    userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
