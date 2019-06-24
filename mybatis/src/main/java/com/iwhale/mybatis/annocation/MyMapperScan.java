package com.iwhale.mybatis.annocation;


import com.iwhale.mybatis.spring.MyImporBeanDefintionRegist;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wzy
 * @date 2019/6/24
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyImporBeanDefintionRegist.class)
public @interface MyMapperScan {
    String[] scanBasePackages() default {};
}
