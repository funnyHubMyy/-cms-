package com.myy.apps.cms.utils;

import java.util.Date;

public class MessageUtils {

    public static Message error(String msg){
        Message message = new Message();
        message.setStatus(500);
        message.setMessage(msg);
        message.setTimeStamp(new Date().getTime());
        return message;
    }

    public static Message success(String msg){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setTimeStamp(new Date().getTime());
        return message;
    }

    public static <T> Message success(T data){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage("查询成功！");
        message.setData(data);
        message.setTimeStamp(new Date().getTime());
        return message;
    }
    public static <T> Message success(T data,String msg){
        Message message = new Message();
        message.setStatus(200);
        message.setMessage(msg);
        message.setData(data);
        message.setTimeStamp(new Date().getTime());
        return message;
    }
}
