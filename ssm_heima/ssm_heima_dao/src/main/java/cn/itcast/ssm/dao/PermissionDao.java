package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface PermissionDao {
    //查询角色所有信息
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findByPermissionsByRoleId(String id) throws Exception;
//查询所有权限
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;
//添加资源权限
    @Insert( "insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission pps) throws Exception;

    //查询角色所拥有的资源权限
    @Select("select *  from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    public List<Permission>findPermissionByRolId(String roleId) throws Exception;

}
