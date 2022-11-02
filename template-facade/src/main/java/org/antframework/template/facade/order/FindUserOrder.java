/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-11-02 15:31 创建
 */
package org.antframework.template.facade.order;

import lombok.Getter;
import lombok.Setter;
import org.antframework.common.util.facade.AbstractOrder;

import javax.validation.constraints.NotEmpty;

/**
 * 查找用户Order
 */
@Getter
@Setter
public class FindUserOrder extends AbstractOrder {
    // 用户ID
    @NotEmpty
    private String userId;
}
