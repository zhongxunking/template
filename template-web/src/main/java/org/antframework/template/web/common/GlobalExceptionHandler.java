/*
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-09-14 16:41 创建
 */
package org.antframework.template.web.common;

import lombok.extern.slf4j.Slf4j;
import org.antframework.common.util.facade.BizException;
import org.antframework.common.util.facade.CommonResultCode;
import org.antframework.common.util.facade.EmptyResult;
import org.antframework.common.util.facade.Status;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Web全局异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    // 处理BizException
    @ExceptionHandler(BizException.class)
    public EmptyResult handleBizException(BizException e) {
        EmptyResult result = new EmptyResult();
        result.setStatus(e.getStatus());
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());

        return result;
    }

    // 处理Exception
    @ExceptionHandler(Exception.class)
    public EmptyResult handleException(Exception e) {
        log.error("web层捕获到未知异常：", e);
        EmptyResult result = new EmptyResult();
        result.setStatus(Status.PROCESSING);
        result.setCode(CommonResultCode.UNKNOWN_ERROR.getCode());
        result.setMessage(e.getMessage());

        return result;
    }
}
