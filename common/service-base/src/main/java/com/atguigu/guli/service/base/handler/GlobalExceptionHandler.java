package com.atguigu.guli.service.base.handler;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.base.result.ResultCodeEnum;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zjiajia
 * @date 2020/9/1 20:46
 *
 * 全局异常处理器
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     * @param e 异常
     * @return  异常原因
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error();
    }

    /**
     * sql 异常处理
     * @param e 异常
     * @return  异常原因
     */
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        return R.setResult(ResultCodeEnum.ARITHMETIC_EXCEPTION);
    }
}
