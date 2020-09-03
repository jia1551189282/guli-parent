package com.atguigu.guli.service.base.handler;

import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.base.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
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
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     * @param e 异常
     * @return  异常原因
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        //e.printStackTrace(); //只会将错误堆栈信息打印在控制台中，不会答应到日志里面
        // 打印出 错误日志
        log.error(ExceptionUtils.getStackTrace(e));
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
        log.error(ExceptionUtils.getStackTrace(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        // 打印出 错误日志
        log.error(ExceptionUtils.getStackTrace(e));
        return R.setResult(ResultCodeEnum.ARITHMETIC_EXCEPTION);
    }
}
