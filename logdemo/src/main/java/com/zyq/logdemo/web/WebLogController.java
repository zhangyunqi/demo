package com.zyq.logdemo.web;

import com.zyq.logdemo.custom.annotation.BussinessName;
import com.zyq.logdemo.custom.annotation.OperateName;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyunqi
 * @date 2018/06/13
 */
@RestController
@BussinessName(module = BussinessName.Module.PAY, business = BussinessName.Business.PAY, function = BussinessName.Function.PAY)
public class WebLogController {

    @RequestMapping("/first")
    @OperateName(operateName = "首页打开", operateType = OperateName.OperateType.LOGIN)
    public String first() {
        return "first controller";
    }
}
