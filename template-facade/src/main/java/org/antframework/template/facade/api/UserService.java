/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-11-02 15:28 创建
 */
package org.antframework.template.facade.api;

import org.antframework.template.facade.order.FindUserOrder;
import org.antframework.template.facade.result.FindUserResult;

/**
 * 用户服务
 */
public interface UserService {
    /**
     * 查找用户
     */
    FindUserResult findUser(FindUserOrder order);
}
