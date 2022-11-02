/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-11-02 15:38 创建
 */
package org.antframework.template.dal.entity;

import lombok.Getter;
import lombok.Setter;
import org.antframework.boot.jpa.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 用户
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "uk_userId", columnNames = "userId"))
@Getter
@Setter
public class User extends AbstractEntity {
    // 用户ID
    @Column(length = 20)
    private String userId;

    // 用户名称
    @Column(length = 64)
    private String userName;

    // 年龄
    @Column
    private Integer age;
}
