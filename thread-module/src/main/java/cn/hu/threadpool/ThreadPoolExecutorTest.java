package cn.hu.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                100,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("测试线程");
                        return thread;
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.err.println("当前任务触发拒绝策略");
                    }
                });

        for (int i = 0; i<1000; i++){
            executor.execute(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println("池大小PoolSize：" + executor.getPoolSize()
                        + "核心线程数CorePoolSize:" + executor.getCorePoolSize()
                            + "最大线程数MaximumPoolSize：" + executor.getMaximumPoolSize()
                            + "达到最大线程数：" + executor.getLargestPoolSize()
                            +"获取线程数ActiveCount：" + executor.getActiveCount()
                            + "总任务数TaskCount：" + executor.getTaskCount()
                            + "已完成任务数：" + executor.getCompletedTaskCount()
                    );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
