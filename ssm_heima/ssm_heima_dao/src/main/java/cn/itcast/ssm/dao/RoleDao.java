package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface RoleDao {
    /**
     * 登陆认证
     * 根据角色id查询资源权限
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select *  from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.PermissionDao.findByPermissionsByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    //查询角色
    @Select("select *  from role")
    List<Role> findAll();
    //添加角色
    @Insert("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);
    //根据ID给角色添加权限
    @Select("select * from role where id = #{roleId} ")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many =@Many(select = "cn.itcast.ssm.dao.PermissionDao.findPermissionByRolId"))
    })
    Role findById(String roleId);
    //查询没有权限的角色
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(String roleId);
    //添加权限
    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
