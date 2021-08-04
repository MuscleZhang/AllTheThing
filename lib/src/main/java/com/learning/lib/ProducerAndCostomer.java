package com.learning.lib;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者消费者
 */
public class ProducerAndCostomer {
    private static final int MAX_LENGTH = 10;
    private Queue<Integer> que = new LinkedList<>();
    private int productId = 0;

    public static void main(String[] args) {
        ProducerAndCostomer obj = new ProducerAndCostomer();
        Producer producer = obj.new Producer();
        Costomer costomer = obj.new Costomer();
        producer.start();
        costomer.start();
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (que) {
                    if (que.size() == MAX_LENGTH) {
                        try {
                            System.out.println("仓库已满");
                            que.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        que.add(productId++);
                        System.out.println("生产 ：" + productId + " 商品");
                        que.notifyAll();
                    }
                }
            }
        }
    }
    class Costomer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (que) {
                    if(que.size() == 0) {
                        try {
                            System.out.println("没货了");
                            que.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        int cur = que.poll();
                        System.out.println("消费了：" + cur + ", 还剩下:" + que.size());
                        que.notifyAll();
                    }
                }
            }
        }
    }

}