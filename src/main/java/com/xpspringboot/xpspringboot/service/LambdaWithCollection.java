package com.xpspringboot.xpspringboot.service;

import com.xpspringboot.xpspringboot.vo.Item;

import java.util.ArrayList;
import java.util.Collections;

/**
 * lambda用于集合相关操作
 */
public class LambdaWithCollection {
    //获取集合中的元素
   public void getListValues() {
       ArrayList<Integer> list = new ArrayList<>();
       Collections.addAll(list, 1,2,3,4,5);

       /**
        *   forEach方法中是一个JDK预定义的函数式接口Consumer
        *   @Override
        *   public void forEach(Consumer<? super E> action) {
        *
        *   所以可以用一个lambda表达式实现这个函数式接口返回一个实列做为参数
        *   传入到forEach()方法中
        */

       //lambda表达式 方法引用
       list.forEach(System.out::println);
       list.forEach(element -> {
           if (element % 2 == 0) {
               System.out.println(element);
           }
       });
   }

   //删除集合中的数据
   public void delListItem() {
       ArrayList<Item> items = new ArrayList<>();
       items.add(new Item(11, "小牙刷", 12.05 ));
       items.add(new Item(5, "日本马桶盖", 999.05 ));
       items.add(new Item(7, "格力空调", 888.88 ));
       items.add(new Item(17, "肥皂", 2.00 ));
       items.add(new Item(9, "冰箱", 4200.00 ));
       items.removeIf(ele -> ele.getId() == 7);
       //通过 foreach 遍历，查看是否已经删除
       items.forEach(System.out::println);
   }

   //使用lambda表达式简化集合排序的写法
    public void sortListItem() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(13, "背心", 7.80));
        list.add(new Item(11, "半袖", 37.80));
        list.add(new Item(14, "风衣", 139.80));
        list.add(new Item(12, "秋裤", 55.33));

        //以前的写法
        /*
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getId()  - o2.getId();
            }
        });
        */
        list.sort((o1, o2) -> o1.getId() - o2.getId());
        System.out.println(list);
    }
}
