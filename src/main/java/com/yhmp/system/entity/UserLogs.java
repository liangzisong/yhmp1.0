package com.yhmp.system.entity;

import java.io.Serializable;

public class UserLogs implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 5905273788837297804L;
    /** 用户表id，外键 */
    private Integer userId;
    /** 用户姓名 */
    private String userName;
    /** 用户点击的方法 */
    private String method;
    /** 用户是否成功 */
    private Integer state;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "UserLogs [userId=" + userId + ", userName=" + userName + ", method="
                + method + ", state=" + state + "]";
    }
    
    
}
