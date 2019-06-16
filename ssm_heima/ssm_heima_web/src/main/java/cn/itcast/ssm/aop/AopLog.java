package cn.itcast.ssm.aop;

import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//日志管理
@Controller
@Aspect
public class AopLog {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService sysLogService;

    @Around("execution(* cn.itcast.ssm.controller.*.*(..))")
//环绕通知
    public Object addLog(ProceedingJoinPoint joinPoint) {

        try {
            //访问时间
            Date visitTime = new Date();
            //登录用户用户名
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            ////访问ip
            String ip = request.getRemoteAddr();
            //访问controller方法的url
            String uri = request.getRequestURI();
            //开始时间
            long start = System.currentTimeMillis();
            Object proceed = joinPoint.proceed();
            //结束时间
            long end = System.currentTimeMillis();
            //访问controller方法的执行时长
            Long  executionTime = end -start;
            //获取切入点方法名
            String methodNane = joinPoint.getSignature().getName();
            //如何获取Controller方法的全类名
            //目标对象
            Object target = joinPoint.getTarget();
            //Controller类的全类名
            String name = target.getClass().getName();
            SysLog sysLog = new SysLog();
            //封装方法
            sysLog.setVisitTime(visitTime);
            sysLog.setUsername(username);
            sysLog.setIp(ip);
            sysLog.setUrl(uri);
            sysLog.setExecutionTime(executionTime);
            sysLog.setMethod(name+"."+methodNane);
            sysLogService.save(sysLog);
            return proceed;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
