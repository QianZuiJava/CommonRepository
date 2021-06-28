package cn.hu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SingleThreadPoolDemo {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("测试线程");
                return thread;
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor(threadFactory);
        for(int i = 0; i<100; i++){
            int finalI = i;
            executorService.execute(()->{
                while (true){
                    try {
                        Thread.sleep(500);
                        System.out.println("当前执行" + finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
