package com.moon.plus.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

// @Data
// @TableName("user1")
public class User implements Serializable {

    private static final long serialVersionUID = -2938308694021945863L;

    /**
     * 主键
     *
     * id
     */
    private Long id;

    /**
     * 姓名
     *
     * name
     */
    private String name;

    /**
     * 年龄
     *
     * age
     */
    @TableField(fill = FieldFill.UPDATE)
    private Integer age;

    /**
     * 邮箱
     *
     * email
     */
    private String email;

    /**
     * 直属上级id
     *
     * manager_id
     */
    private Long managerId;

    /**
     * 创建时间
     *
     * create_time
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    @TableField(fill = FieldFill.UPDATE)
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     *
     * update_time
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 版本
     *
     * version
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除标识(0.未删除,1.已删除)
     *
     * deleted
     */
    @TableLogic
    @TableField(select = false)
    private Integer deleted;


    /**
     * 重写 toString() 函数
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", managerId=" + managerId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                ", deleted=" + deleted +
                '}';
    }


    /**
     * 全参构造函数
     *
     * @param id
     * @param name
     * @param age
     * @param email
     * @param managerId
     * @param createTime
     * @param updateTime
     * @param version
     * @param deleted
     */
    public User(Long id, String name, Integer age, String email, Long managerId, LocalDateTime createTime, Date updateTime, Integer version, Integer deleted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.managerId = managerId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.version = version;
        this.deleted = deleted;
    }


    /**
     * 无参构造函数
     */
    public User() {
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
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }


}
