package com.sun.www.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author suny
 * @version 1.0
 * @date 2017年09月25日
 */
@ControllerAdvice
public class AControllerAdvice {

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public JSONObject handleIOException(Exception ex) {
//        ResultEntity resultEntity = new ResultEntity();
//        if (ex.getClass() == SunException.class) {
//            SunException sun = (SunException) ex;
//            resultEntity.setCode(sun.getCode());
//            resultEntity.setMsg(sun.getMsg());
//            resultEntity.setObj("");
//        } else {
//            resultEntity.setCode(-1);
//            resultEntity.setMsg(ex.getMessage());
//            resultEntity.setObj("");
//        }
//        return JSONObject.fromObject(resultEntity);
//    }
}