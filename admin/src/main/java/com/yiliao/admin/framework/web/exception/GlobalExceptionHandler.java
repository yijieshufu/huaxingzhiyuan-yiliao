package com.yiliao.admin.framework.web.exception;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.yiliao.admin.common.constant.HttpStatus;
import com.yiliao.admin.common.domain.RespResult;
import com.yiliao.admin.common.exception.ServiceException;
import com.yiliao.admin.common.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.yiliao.admin.common.constant.ErrorCodeConstants;
import com.yiliao.admin.common.exception.AuthException;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

/**
 * 全局异常处理器
 *
 * @author lihong
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public RespResult handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return RespResult.error("没有权限，请联系管理员授权", HttpStatus.FORBIDDEN);
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RespResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                          HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return RespResult.error("不支持该类型的请求", HttpStatus.BAD_METHOD);
    }


    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public RespResult handleServiceException(ServiceException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        String message = e.getMessage();
        if (StringUtils.isBlank(message)) {
            message = "操作失败";
        }
        return RespResult.error(message, e.getErrorCode(), HttpStatus.BAD_REQUEST);
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(SystemException.class)
    public RespResult handleSystemException(SystemException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return RespResult.error("系统异常，请联系管理员", e.getErrorCode(), HttpStatus.ERROR);
    }

    /**
     * 认证异常
     */
    @ExceptionHandler(AuthException.class)
    public RespResult handleAuthException(AuthException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生认证异常.", requestURI, e);
        return RespResult.error("登录状态已过期，请重新登录", e.getErrorCode(), HttpStatus.UNAUTHORIZED);
    }


    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public RespResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return RespResult.error("系统异常，请联系管理员");
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public RespResult handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return RespResult.error("系统异常，请联系管理员");
    }



    /**
     * 请求不支持异常
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public RespResult handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生请求不支持异常.", requestURI, e);
        return RespResult.error("请求类型不支持，请检查Content-Type是否设置正确", ErrorCodeConstants.CONTENT_TYPE_ERROR, HttpStatus.BAD_REQUEST);
    }
}
