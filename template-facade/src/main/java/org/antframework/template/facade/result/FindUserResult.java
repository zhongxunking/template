/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-11-02 15:32 创建
 */
package org.antframework.template.facade.result;

import lombok.Getter;
import lombok.Setter;
import org.antframework.common.util.facade.AbstractResult;
import org.antframework.template.facade.info.UserInfo;

/**
 * 查找用户Result
 */
@Getter
@Setter
public class FindUserResult extends AbstractResult {
    // 用户(null表示不存在)
    private UserInfo user;
}
