/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-11-02 15:29 创建
 */
package org.antframework.template.facade.info;

import lombok.Getter;
import lombok.Setter;
import org.antframework.common.util.facade.AbstractInfo;

/**
 * 用户信息
 */
@Getter
@Setter
public class UserInfo extends AbstractInfo {
    // 用户ID
    private String userId;
    // 用户名称
    private String userName;
    // 年龄
    private Integer age;
}
