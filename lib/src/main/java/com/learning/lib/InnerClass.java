package com.learning.lib;

/**
 * 学习内部类
 */
public class InnerClass {
    static int sInt = 1;
    String mString = "";

    /**
     * 静态内部类
     * 调用方式：
     * InnerClass.StaticInner inner = new InnerClass.StaticInner();
     * inner.get();
     */
    static class StaticInner {
        public static void get() {
            System.out.println("static get");
        }
    }

    /**
     * 成员内部类
     * 调用方式：
     * InnerClass.Inner inner = new InnerClass().new Inner();
     * inner.get();
     */
    class Inner {
        public void get() {
            String a = mString;
            System.out.println("inner get");
        }
    }
}
