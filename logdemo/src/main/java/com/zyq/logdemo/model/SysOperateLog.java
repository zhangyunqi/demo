package com.zyq.logdemo.model;

import javax.persistence.*;

/**
 * @author zhangyunqi
 * @date 2018/06/12
 */
@Entity
@Table(name = "SYS_OPERATE_LOG")
public class SysOperateLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SGuid;
}
