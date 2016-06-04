package org.zhyan.fixed.bean;

import java.util.Date;

import org.zhyan.fixed.util.MD5;


public class User {
    private String guid;

    private Long id;

    private String name;

    private String pass;

    private String tel;

    private Date createTime;

    private String state;

    private String ipAddress;

    
    public User()
    {
    	
    }
    
    public User(String name,String pass)
    {
    	this.name = name;
        MD5 md5 = new MD5();
    	this.pass = md5.passToMd5(pass);
    }
    
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}