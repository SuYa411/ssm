package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserDao {

    /**
     * 登录认证
     *
     * @param username
     * @return
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = java.util.List.class, many = @Many(select = "cn.itcast.ssm.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);

    //查询所有用户
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;



    //添加用户
    @Insert("insert into users(email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo user) throws Exception;


    //根据用户id查询用户所拥有觉得集合
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = java.util.List.class, many = @Many(select = "cn.itcast.ssm.dao.RoleDao.findRoleByUserId"))
    })
    public UserInfo findById(String roleId);


//根据用户Id添加角色
    @Select("select * from role where id not in (select roleId from users_role where userId = #{id})")
    List<Role> findOtherRole(String id);


    @Insert("insert into users_role (userId,roleId) values (#{userId},#{roleId})")
    void addRoleToUser(@Param("userId")String userId,@Param("roleId")String roleId);
//    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);


}
