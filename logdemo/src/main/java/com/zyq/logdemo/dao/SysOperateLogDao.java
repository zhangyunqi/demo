package com.zyq.logdemo.dao;

import com.zyq.logdemo.model.SysOperateLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 系统用户操作日志的操作
 * @author zhangyunqi
 * @date 2018/06/13
 */
@Repository
public interface SysOperateLogDao extends CrudRepository<SysOperateLog,Long>{

}

