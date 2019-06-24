package com.iwhale.mybatis.proxy;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wzy
 * @date 2019/6/23
 */
public class MapperInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.isAnnotationPresent(Select.class))   System.out.println(method.getAnnotation(Select.class).value()[0]);

        if(method.isAnnotationPresent(Update.class))   System.out.println(method.getAnnotation(Update.class).value()[0]);

        return null;
    }



}
