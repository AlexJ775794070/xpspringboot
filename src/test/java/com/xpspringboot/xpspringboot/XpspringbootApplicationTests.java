package com.xpspringboot.xpspringboot;

import com.xpspringboot.xpspringboot.service.LambdaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XpspringbootApplicationTests {
    @Autowired
    private LambdaServiceImpl lambdaService;
    @Test
    void contextLoads() {
        lambdaService.testPredicate();
        lambdaService.testConsumer();
    }

}
