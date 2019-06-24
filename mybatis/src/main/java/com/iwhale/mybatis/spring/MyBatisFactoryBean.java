package com.iwhale.mybatis.spring;

import com.iwhale.mybatis.proxy.MapperInvocationHandler;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author wzy
 * @date 2019/6/23
 */
public class MyBatisFactoryBean implements FactoryBean {
    Class  aClass;

    public MyBatisFactoryBean(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public Object getObject() throws Exception {
        Class[] clazz = new Class[]{aClass};
        Object mapper = Proxy.newProxyInstance(MyBatisFactoryBean.class.getClassLoader(),clazz,new MapperInvocationHandler());
        return mapper;
    }

    @Override
    public Class<?> getObjectType() {
        return aClass;
    }
}
