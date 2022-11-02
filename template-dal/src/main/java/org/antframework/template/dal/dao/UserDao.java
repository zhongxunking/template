/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-11-02 15:41 创建
 */
package org.antframework.template.dal.dao;

import org.antframework.template.dal.entity.User;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * 用户Dao
 */
@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserDao {

    User findByUserId(String userId);
}
