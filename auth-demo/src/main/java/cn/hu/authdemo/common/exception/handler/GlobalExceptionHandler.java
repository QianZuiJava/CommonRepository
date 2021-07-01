package cn.hu.authdemo.common.exception.handler;

import cn.hu.authdemo.common.exception.BusinessException;
import cn.hu.authdemo.common.model.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public BaseResult handleBusinessException(BusinessException e){
        return BaseResult.businessException(e);
    }
}
