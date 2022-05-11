package com.brendan.junit5;

import org.junit.jupiter.api.Test;

public class SecondParallelTest {

    @Test
    public void first() throws Exception{
        System.out.println("SecondParallelTest first() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("SecondParallelTest first() end => " + Thread.currentThread().getName());
    }

    @Test
    public void second() throws Exception{
        System.out.println("SecondParallelTest second() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("SecondParallelTest second() end => " + Thread.currentThread().getName());
    }
}
