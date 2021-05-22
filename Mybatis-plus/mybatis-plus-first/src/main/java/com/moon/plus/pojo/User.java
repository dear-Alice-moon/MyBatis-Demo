package com.moon.plus.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

// @Data
@TableName("mp_user")
public class User implements Serializable {

    private static final long serialVersionUID = -2938308694021945863L;

    /**
     * 主键
     *
     * id
     */
    // @TableId
    @TableField("id")
    private Long userId;

    /**
     * 姓名
     *
     * name
     */
    @TableField("real_name")
    private String name;

    /**
     * 年龄
     *
     * age
     */
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
    private Date createTime;


    /**
     * 备注信息，用于存储信息。表中没有字段与之对应。
     *
     * remark
     */
    @TableField(exist = false)  // Mybatis-plus中此注解属性表示该属性与表中字段没有映射。
    private String remark;


    /**
     * 全参构造函数
     *
     * @param userId
     * @param name
     * @param age
     * @param email
     * @param managerId
     * @param createTime
     * @param remark
     */
    public User(Long userId, String name, Integer age, String email, Long managerId, Date createTime, String remark) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.managerId = managerId;
        this.createTime = createTime;
        this.remark = remark;
    }


    /**
     * 重写 toString() 函数
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", managerId=" + managerId +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                '}';
    }


    /**
     * 与表全部字段对应的构造函数
     *
     * @param userId
     * @param name
     * @param age
     * @param email
     * @param managerId
     * @param createTime
     */
    public User(Long userId, String name, Integer age, String email, Long managerId, Date createTime) {
        this.userId= userId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.managerId = managerId;
        this.createTime = createTime;
    }


    /**
     * 无参构造函数
     */
    public User() {
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
