package com.xpspringboot.xpspringboot;

import com.xpspringboot.xpspringboot.vo.Item;

public interface ItemCreatorParamContruct {
    Item getItem(int id, String name, double price);
}
