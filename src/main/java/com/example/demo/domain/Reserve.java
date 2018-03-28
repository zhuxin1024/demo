package com.example.demo.domain;

import java.util.Date;

/**
 * Created by zhuxin5 on 2018/3/26.
 */
public class Reserve {
    private Long id;
    /**
     * 教材编号
     */
    private Long number;
    /**
     * 预定数量
     */
    private Long reserves;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date modified;
    /**
     * 状态
     */
    private int status;
    /**
     * 教师id
     */
    private Long tid;
    /**
     * 教师名
     */
    private String tname;
    /**
     * 班级
     */
    private String classinfo;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getReserves() {
        return reserves;
    }

    public void setReserves(Long reserves) {
        this.reserves = reserves;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(String classinfo) {
        this.classinfo = classinfo;
    }
}
