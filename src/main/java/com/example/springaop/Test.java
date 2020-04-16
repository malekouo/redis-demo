package com.example.springaop;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    public static ConcurrentLinkedQueue<SpringGift> queue;
    public static SpringGift currGift;
    public static AtomicInteger count = new AtomicInteger();
    static class myThread implements Runnable{
        public void run(){
            handleEvent();
        }
    }
    public static void main(String[] args) throws Exception {
        queue = new ConcurrentLinkedQueue<SpringGift>();
        for(int i =0;i<3;i++){
            SpringGift gift = new SpringGift();
            gift.setRole("role"+i);
            gift.setGift(new AtomicInteger(50));
            queue.add(gift);
        }
        myThread mythread = new myThread();
        for(int i=0;i<1000;i++){
            new Thread(mythread).start();
        }

        System.err.println("总共收到"+count.get());
    }
    private static SpringGift getGift(){
        //防止多条线程同时弹出队首
        synchronized (queue) {//若没有加锁，打印的count总数不对！！！！
            if(currGift == null){
                System.out.println("从队列中取出一个");
                currGift = queue.poll();
            }
        }
        return currGift;
    }
    public static void handleEvent(){
        try{
            SpringGift obj = getGift();

            if(obj == null ){
                System.err.println("没有了");
                return ;
            }
            if(obj !=null && obj.getGift().getAndDecrement() >0 ){
                System.err.println("抢到一个红包");
                count.getAndIncrement();
                System.out.println("count 的值"+count.getAndIncrement());
            }
            Thread.sleep(500);//模拟处理其他操作
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
