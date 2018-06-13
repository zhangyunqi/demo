package com.zyq.logdemo.custom.annotation;

import java.lang.annotation.*;

/**
 * @author zhangyunqi
 * @date 2018/06/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateName {
    public enum OperateType {
        ADD, UPDATE, DELETE, LOGIN, LOGOUT, QUERY
    }

    public String operateName();

    public OperateType operateType();
}
