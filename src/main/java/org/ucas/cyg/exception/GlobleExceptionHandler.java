package org.ucas.cyg.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ucas.cyg.result.CodeMsg;
import org.ucas.cyg.result.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 21:19
 * @Description:
 */

@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        e.printStackTrace();
        if (e instanceof GlobleException) {
            GlobleException ge = (GlobleException) e;
            return Result.error(ge.getCodeMsg());
        }else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String defaultMessage = error.getDefaultMessage();
            return Result.error(CodeMsg.BIND_ERROR.fillArgs(defaultMessage));
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }

    }
}
