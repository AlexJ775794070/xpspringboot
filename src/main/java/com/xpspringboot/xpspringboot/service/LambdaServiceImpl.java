package com.xpspringboot.xpspringboot.service;

import com.xpspringboot.xpspringboot.vo.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 函数接口是只有一个抽象方法的接口,用作lambda表达式的类型
 * 使用@FunctionalInterface注解修饰的类，编译器会检查该类是否只有一个抽象方法或接口，否则，会报错
 * 可以有多个默认方法，静态方法
 * Java1.8自带了一些常用的函数式接口
 *
 * 语法形式为 () -> {}，其中 () 用来描述参数列表，{} 用来描述方法体，-> 为 lambda运算符 ，读作(goes to)。
 *
 * jdk 8 中有另一个新特性：default， 被 default 修饰的方法会有默认实现，
 * 不是必须被实现的方法，所以不影响 Lambda 表达式的使用。
 *
 * 简化写法：
 * 1.实现函数式接口的时候可以不指定参数类型，如果不指定的话，所有参数都不指定类型，因为定义的时候已经指定了
 * 2.
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
     * @FunctionalInterface
     * public interface Function<T, R> {
     * 传入T类型，返回R类型
     * 里面一个apply()方法，接收一个T类型的，返回一个R类型的
     *  R apply(T t);
     */
    public void testFunction() {
        //User::getName; 这个就是apply方法的实现
        //functionTest就是Function对象的引用
        User u = new User();
        u.setName("XP");
        u.setAge(18);
        u.setSex(false);
      Function<User,String> functionTest = User::getName;
       String name = functionTest.apply(u);
        System.out.println("name: " + name);
    }

    /**
     * 产生消息,返回一个T类型的
     * @FunctionalInterface
     * public interface Supplier<T>
     *只有一个方法
     * T get();
     */
    public void testSupplier() {
        Supplier<String> supplier = () -> "Factory";
        System.out.println("supplier: " + supplier.get());

    }

    /**
     * 一元操作，逻辑非（！）
     *
     */
    public void testUnaryOperator() {
        UnaryOperator<Boolean> unaryOperator = x -> !x;
        System.out.println(unaryOperator.apply(false));
    }

    /**
     * 二元操作
     * @FunctionalInterface
     * public interface BinaryOperator<T> extends BiFunction<T,T,T>
     * R apply(T t, U u);
     *传入T,U返回R
     * 所以加减乘除这些运算符合这个函数接口
     */
    public void testBinaryOperator() {
        BinaryOperator<Integer> binaryOperator = (x,y) -> x+y;
        System.out.println(binaryOperator.apply(2,8));
    }

    /**
     * 惰性求值与及早求值
     * 惰性求值就是得到的结果还是Stream流
     * 及早求值就是得到最终结果而不是一个stream流
     * stream流在集合中有着广泛的应用
     */
    public void testStream() {
        List<User> studentList = Stream.of(new User("路飞", 22, true),
                new User("红发", 40, true),
                new User("白胡子", 50, true)).collect(Collectors.toList());
        System.out.println(studentList);

        //studentList.stream()
    }
}
