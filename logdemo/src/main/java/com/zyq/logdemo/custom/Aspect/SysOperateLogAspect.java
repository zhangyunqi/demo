package com.zyq.logdemo.custom.Aspect;

import com.alibaba.fastjson.JSON;
import com.zyq.logdemo.custom.annotation.BussinessName;
import com.zyq.logdemo.custom.annotation.OperateName;
import com.zyq.logdemo.dao.SysOperateLogDao;
import com.zyq.logdemo.model.SysOperateLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * 系统日志操作的Aspect
 *
 * @author zhangyunqi
 * @date 2018/06/13
 */
@Aspect
@Component
public class SysOperateLogAspect {
    @Autowired
    SysOperateLogDao sysOperateLogDao;

    /**
     * 切面
     */
    @Pointcut("execution(public * com.zyq.logdemo.web.*.*(..))")
    public void webLog() {
    }

    /**
     * 之前执行过程
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession httpSession = request.getSession();

        Date operateTime = new Date();

        //session获取用户信息 S_USERID S_USERNAME

        //httpSession.getAttribute("userId")
        Long userid = 1L;
        //httpSession.getAttribute("userId")
        String username = "李四";

        //填写请求业务信息
        //0代表未知
        String module = "0";
        String business = "0";
        String function = "0";
        String operateName = "Unknown";
        String operateType = "Unknown";

        //获取执行的类，通过类获取反射的注解信息
        Class clz = joinPoint.getTarget().getClass();
        boolean clzHasAnno = clz.isAnnotationPresent(BussinessName.class);
        if (clzHasAnno) {
            BussinessName bussinessNameAnno = (BussinessName) clz.getAnnotation(BussinessName.class);
            module = bussinessNameAnno.module().getCode();
            business = bussinessNameAnno.function().getCode();
            function = bussinessNameAnno.function().getCode();
        }
        //获取执行的方法，通过方法获取反射的注解信息
        Method med = ((MethodSignature) joinPoint.getSignature()).getMethod();
        boolean methodHasAnno = med.isAnnotationPresent(OperateName.class);
        if (methodHasAnno) {
            OperateName operateNameAnno = med.getAnnotation(OperateName.class);
            operateName = operateNameAnno.operateName();
            operateType = operateNameAnno.operateType().name();
        }

        //获取请求信息
        String url = request.getRequestURL().toString();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String requestParams = JSON.toJSONString(parameterMap);

        //获取客户端和服务器端信息
        String clientIp = request.getRemoteAddr();
        String serverIp = request.getLocalAddr();

        SysOperateLog sysOperateLog = new SysOperateLog(userid, username, module, business, function, operateName, url,
                requestParams, operateType, operateTime, clientIp, serverIp);

        sysOperateLogDao.save(sysOperateLog);

    }
}
