package com.example.springaop.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class BaseDTO implements Serializable {
    @JSONField(name = "created_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @JSONField(name = "updated_at", format = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;

    @JSONField(name = "created_by")
    private String createdBy;

    @JSONField(name = "updated_by")
    private String updatedBy;

    @JSONField(name = "archive")
    private int archive;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public int getArchive() {
        return archive;
    }

    public void setArchive(int archive) {
        this.archive = archive;
    }
}
