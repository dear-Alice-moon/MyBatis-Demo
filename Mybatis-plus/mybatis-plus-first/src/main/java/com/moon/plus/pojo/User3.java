package com.moon.plus.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@TableName("user")
// @EqualsAndHashCode(callSuper = false)
public class User3 extends Model<User3> implements Serializable {

    private static final long serialVersionUID = -2938308694021945863L;

    /**
     * 主键
     *
     * id
     */
    @TableId
    private Long Id;

    /**
     * 姓名
     *
     * name
     */
    @TableField(condition = SqlCondition.LIKE)
    private String name;

    /**
     * 年龄
     *
     * age
     */
    @TableField(condition = "%s&lt;#{%s}")
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
    private Date createTime;




    /**
     * 重写 toString() 函数
     *
     * @return
     */
    @Override
    public String toString() {
        return "User3{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", managerId=" + managerId +
                ", createTime=" + createTime +
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
     */
    public User3(Long id, String name, Integer age, String email, Long managerId, Date createTime) {
        Id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.managerId = managerId;
        this.createTime = createTime;
    }


    /**
     * 无参构造函数
     *
     */
    public User3() {

    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.email = email;
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
}
