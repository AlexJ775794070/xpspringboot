package com.xpspringboot.xpspringboot.service;
import com.xpspringboot.xpspringboot.vo.User;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;
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
     *  boolean test(T t);
     */
     public void testPredicate() {
         Predicate<String> predicateTest = name -> "Alex".equals(name);
         System.out.println("是Alex吗? " + predicateTest.test("xp"));
     }
     /**
     * 2.comsumer:消费者，消费一个消息，然后输出一个值
     * 里面一个accept()方法接收一个输入参数，然后自己写处理逻辑
      * void accept(T t);
     */
     public void testConsumer() {
        Consumer<String> consumerTest =  inParam -> System.out.println("处理逻辑我也不想写了，你输入了啥？ -》 " + inParam);
        consumerTest.accept("学习lambda！");
     }
    /**
     * 3.Function，将T映射为R(转换功能)
     * 里面一个apply()方法，接收一个T类型的，返回一个R类型的
     *  R apply(T t);
     */
    public void testFunction() {
       // Function<User> functionTest =
    }



}
