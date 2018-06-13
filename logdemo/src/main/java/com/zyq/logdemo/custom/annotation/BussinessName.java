package com.zyq.logdemo.custom.annotation;

import org.omg.SendingContext.RunTime;

import java.lang.annotation.*;

/**
 * @author zhangyunqi
 * @date 2018/06/13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BussinessName {
    /**
     * 定义模块 例如 支付模块
     */
    public enum Module {
        PAY("1001"), USER("1002"), SYSTEM("1003");
        private String code;

        private Module(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    ;

    /**
     * 定义业务 例如 人员管理
     */
    public enum Business {
        PAY("1001"), USER("1002"), SYSTEM("1003");
        private String code;

        private Business(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    ;

    /**
     * 定义功能 例如人员参保
     */
    public enum Function {
        PAY("1001"), USER("1002"), SYSTEM("1003");
        private String code;

        private Function(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    ;

    public Module module();

    public Business business();

    public Function function();

}
