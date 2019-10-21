package com.xpspringboot.xpspringboot.service;

/**
 * 多个参数一个返回值
 */
@FunctionalInterface
public interface ReturnMultiParam {
    int method(int a, int b);
}
