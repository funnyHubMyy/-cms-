package com.myy.apps.cms.config;

import com.myy.apps.cms.utils.Message;
import com.myy.apps.cms.utils.MessageUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public <E> Message Handler(Exception exception){
        exception.printStackTrace();
        return MessageUtils.error(exception.getMessage());
    }

}
