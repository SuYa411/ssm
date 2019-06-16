package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {
    //添加日志
    void save(SysLog sysLog) throws Exception;
    //查询日志
    List<SysLog> findAll() throws Exception;
}
