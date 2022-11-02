/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-11-02 15:50 创建
 */
package org.antframework.template.test.facade.api;

import lombok.extern.slf4j.Slf4j;
import org.antframework.common.util.facade.FacadeUtils;
import org.antframework.template.facade.api.UserService;
import org.antframework.template.facade.order.FindUserOrder;
import org.antframework.template.facade.result.FindUserResult;
import org.antframework.template.test.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 用户服务单元测试
 */
@Slf4j
public class UserServiceTest extends AbstractTest {
    @Autowired
    private UserService userService;

    // 查找用户
    @Test
    public void testFindUser() {
        FindUserOrder order = new FindUserOrder();
        order.setUserId("123");

        FindUserResult result = userService.findUser(order);
        log.info("执行结果：{}", result);
        FacadeUtils.assertSuccess(result);
    }
}
