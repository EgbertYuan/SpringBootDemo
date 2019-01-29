package cn.egbert.shop.controller;

import cn.egbert.shop.error.BusinessException;
import cn.egbert.shop.error.EmBussinessError;
import cn.egbert.shop.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";
    //定义ExceptionHandler解决未被controller层吸收的异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception e) {
        if (e instanceof BusinessException) {
            BusinessException e1 = (BusinessException) e;
            return CommonReturnType.createFailure(e1.getErrorMsg(), e1.getErrorCode());
        } else {
            return CommonReturnType.createFailure(EmBussinessError.UNKNOWN.getErrorMsg(), EmBussinessError.UNKNOWN.getErrorCode());
        }
    }
}
