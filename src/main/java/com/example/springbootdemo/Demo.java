package com.example.springbootdemo;

public class Demo {

    private static int count;

    public static void main(String[] args) {
        new Thread(()->{
            count++;
            System.out.println(Thread.currentThread().getName()+"==="+count);
        },"A").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"==="+count);
        },"B").start();
    }
}
