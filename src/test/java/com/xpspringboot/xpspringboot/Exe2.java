package com.xpspringboot.xpspringboot;

import com.xpspringboot.xpspringboot.vo.Item;

public class Exe2 {
    /**
     *用接口作为对象的生成器，通过类::new关键字直接生成对象返回
     */
    public static void main(String[] args) {
        ItemCreatorBlankConstruct creator = () -> new Item();
        Item item = creator.getItem();

        ItemCreatorBlankConstruct creator2 = Item::new;
        Item item2 = creator2.getItem();

        ItemCreatorParamContruct creator3 = Item::new;
        Item item3 = creator3.getItem(112, "鼠标", 135.99);
    }
}
