package com.iwhale.mybatis;


import com.iwhale.mybatis.Service.UserServiceImpl;
import com.iwhale.mybatis.annocation.MyMapperScan;
import com.iwhale.mybatis.mapper.TaskMapper;
import com.iwhale.mybatis.mapper.UserMapper;
import com.iwhale.mybatis.spring.MyImporBeanDefintionRegist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;



@MyMapperScan(scanBasePackages={"com.iwhale.mybatis.mapper"})
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
  /*      Class[] classes = new Class[]{UserMapper.class,TaskMapper.class};
        UserMapper userMapper1 = (UserMapper) Proxy.newProxyInstance(MybatisApplication.class.getClassLoader(),classes,new MapperInvocationHandler());
        TaskMapper taskMapper = (TaskMapper) Proxy.newProxyInstance(MybatisApplication.class.getClassLoader(),classes,new MapperInvocationHandler());
        userMapper1.getUserById();
        taskMapper.taskList();
        System.out.println(Proxy.getProxyClass(UserMapper.class.getClassLoader(),UserMapper.class));*/
        ConfigurableApplicationContext context = SpringApplication.run(MybatisApplication.class, args);
     /*   UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        userMapper.getAllUser();*/
        UserMapper mapper = (UserMapper) context.getBean("userMapper");
        TaskMapper taskMapper = context.getBean(TaskMapper.class);
        taskMapper.taskList();
        mapper.getAllUser();
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.getAllUsers();
    }

}
