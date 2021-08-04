package com.learning.lib;

import java.util.LinkedList;
import java.util.Queue;

public class KnowledgePointTest {

    public static void main(String[] args) {
        InnerClass.StaticInner.get();
//        InnerClass.StaticInner inner = new InnerClass.StaticInner();
//        inner.get();
//        InnerClass.Inner inner = new InnerClass().new Inner();
//        inner.get();
//        KnowledgePointTest obj = new KnowledgePointTest();
//        MyThread thread = obj.new MyThread();
//        System.out.println(System.currentTimeMillis() + "Main thread start:" + thread);
//        Object lock = new Object();
//        thread.start();
//        synchronized (thread) {
//            try {
//                System.out.println("before wait");
//                thread.wait();
//                System.out.println("after wait");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                System.out.println("finally");
//            }
//        }
////        try {
//////            System.out.println(System.currentTimeMillis() + "join start");
////            thread.join(1);
////            System.out.println(System.currentTimeMillis() + "join end");
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        System.out.println(System.currentTimeMillis() + "Main thread end");
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "MyThread start :" + currentThread());
            synchronized (currentThread()) {
                for(int i = 0;i < 20;i++) {
                    try {
                        sleep(1000);
                        if(i == 10) {
                            wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Mythread-----:" + i);
                }
                System.out.println("MyThread end");
            }
        }
    }
}