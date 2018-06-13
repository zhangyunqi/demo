package com.zyq.logdemo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangyunqi
 * @date 2018/06/12
 */
@Entity
@Table(name = "SYS_OPERATE_LOG")
public class SysOperateLog implements Serializable{
    /**
     * 主键用ong类型
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nGuid;
    private Long nUserid;
    private String sUsername;
    private String sModule;
    private String sBusiness;
    private String sFunction;
    private String sOperateName;
    private String sUrl;
    private String sRequestParams;
    private String sOperateType;
    private Date dOperateTime;
    private String sClientIp;
    private String sServerIp;

    public SysOperateLog() {
    }

    public SysOperateLog(Long nUserid, String sUsername, String sModule, String sBusiness, String sFunction,
                         String sOperateName, String sUrl, String sRequestParams, String sOperateType,
                         Date dOperateTime, String sClientIp, String sServerIp) {
        this.nUserid = nUserid;
        this.sUsername = sUsername;
        this.sModule = sModule;
        this.sBusiness = sBusiness;
        this.sFunction = sFunction;
        this.sOperateName = sOperateName;
        this.sUrl = sUrl;
        this.sRequestParams = sRequestParams;
        this.sOperateType = sOperateType;
        this.dOperateTime = dOperateTime;
        this.sClientIp = sClientIp;
        this.sServerIp = sServerIp;
    }

    public Long getnGuid() {
        return nGuid;
    }

    public void setnGuid(Long nGuid) {
        this.nGuid = nGuid;
    }

    public Long getnUserid() {
        return nUserid;
    }

    public void setnUserid(Long nUserid) {
        this.nUserid = nUserid;
    }

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public String getsModule() {
        return sModule;
    }

    public void setsModule(String sModule) {
        this.sModule = sModule;
    }

    public String getsBusiness() {
        return sBusiness;
    }

    public void setsBusiness(String sBusiness) {
        this.sBusiness = sBusiness;
    }

    public String getsFunction() {
        return sFunction;
    }

    public void setsFunction(String sFunction) {
        this.sFunction = sFunction;
    }

    public String getsOperateName() {
        return sOperateName;
    }

    public void setsOperateName(String sOperateName) {
        this.sOperateName = sOperateName;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getsRequestParams() {
        return sRequestParams;
    }

    public void setsRequestParams(String sRequestParams) {
        this.sRequestParams = sRequestParams;
    }

    public String getsOperateType() {
        return sOperateType;
    }

    public void setsOperateType(String sOperateType) {
        this.sOperateType = sOperateType;
    }

    public Date getdOperateTime() {
        return dOperateTime;
    }

    public void setdOperateTime(Date dOperateTime) {
        this.dOperateTime = dOperateTime;
    }

    public String getsClientIp() {
        return sClientIp;
    }

    public void setsClientIp(String sClientIp) {
        this.sClientIp = sClientIp;
    }


    public String getsServerIp() {
        return sServerIp;
    }

    public void setsServerIp(String sServerIp) {
        this.sServerIp = sServerIp;
    }
}