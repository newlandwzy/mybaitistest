package com.iwhale.mybatis.spring;

import com.iwhale.mybatis.annocation.MyMapperScan;
import com.iwhale.mybatis.mapper.UserMapper;
import com.iwhale.mybatis.util.ClassUtil;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wzy
 * @date 2019/6/23
 */
public class MyImporBeanDefintionRegist implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //获取注解的属性信息
        //这里可以获取到注解的详细信息，然后根据信息去动态的返回需要被spring容器管理的bean
        Map paramMap = annotationMetadata.getAnnotationAttributes(MyMapperScan.class.getName());
//        importingClassMetadata.getAnnotatedMethods(MyMapperScan.class.getName());
        String[] pages = (String[]) paramMap.get("scanBasePackages");
        for(String pagePath:pages){
            List<Class<?>> classes = ClassUtil.getClasses(pagePath);
            for(Class claz:classes){
                if(claz.isInterface()) {
                    String alis = claz.getName().substring(claz.getName().lastIndexOf(".")+1);
                    Regist(beanDefinitionRegistry,claz,toLowerCaseFirstOne(alis));
                }
            }
        }
    }

    private void Regist(BeanDefinitionRegistry beanDefinitionRegistry,Class cl,String className){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyBatisFactoryBean.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(cl);
        beanDefinitionRegistry.registerBeanDefinition(className,beanDefinition);
    }

    /**
     * 首字母小写化
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
