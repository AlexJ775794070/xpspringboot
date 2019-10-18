package com.xpspringboot.xpspringboot.service;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * 函数接口是只有一个抽象方法的接口,用作lambda表达式的类型
 * 使用注解修饰的类，编译器会检查该类是否只有一个抽象方法或接口，否则，会报错
 * 可以有多个默认方法，静态方法
 * Java1.8自带了一些常用的函数式接口
 */
@Component
public class LambdaServiceImpl implements LambdaService {


    /**
     * 1.predicate：谓词，断言，判断真假，返回一个boolean值
     * 里面就一个test方法，用于返回true或者false
     */
     public void testPredicate() {
         Predicate<String> predicateTest = name -> "Alex".equals(name);
         System.out.println("是Alex吗? " + predicateTest.test("xp"));
     }

}
