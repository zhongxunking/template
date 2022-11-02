/*
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-08-22 15:42 创建
 */
package org.antframework.template.test;

import org.antframework.boot.lang.Apps;
import org.antframework.template.Main;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 单元测试父类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class AbstractTest {
    static {
        // 设置使用环境
        Apps.setProfileIfAbsent("dev");
    }
}
