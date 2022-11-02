/*
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-06-22 11:34 创建
 */
package org.antframework.template.assemble;

import org.antframework.boot.lang.AntBootApplication;
import org.antframework.boot.lang.Apps;
import org.springframework.boot.SpringApplication;

/**
 * 程序启动入口
 */
@AntBootApplication(appId = "template")
public class Main {
    public static void main(String[] args) {
        Apps.setProfileIfAbsent("dev");
        SpringApplication.run(Main.class, args);
    }
}
