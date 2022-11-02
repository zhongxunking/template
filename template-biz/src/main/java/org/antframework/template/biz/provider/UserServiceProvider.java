/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-11-02 15:37 创建
 */
package org.antframework.template.biz.provider;

import lombok.AllArgsConstructor;
import org.antframework.common.util.facade.FacadeUtils;
import org.antframework.template.dal.dao.UserDao;
import org.antframework.template.dal.entity.User;
import org.antframework.template.facade.api.UserService;
import org.antframework.template.facade.info.UserInfo;
import org.antframework.template.facade.order.FindUserOrder;
import org.antframework.template.facade.result.FindUserResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 用户服务提供者
 */
@Service
@AllArgsConstructor
public class UserServiceProvider implements UserService {
    // 用户Dao
    private final UserDao userDao;

    @Override
    public FindUserResult findUser(FindUserOrder order) {
        // 校验入参是否符合约定
        order.check();

        // 从数据库查询用户
        User user = userDao.findByUserId(order.getUserId());

        // 构造返回结构
        FindUserResult result = FacadeUtils.buildSuccess(FindUserResult.class);
        result.setUser(convert(user));
        return result;
    }

    // 转换
    private UserInfo convert(User user) {
        if (user == null) {
            return null;
        }
        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(user, info);
        return info;
    }
}
