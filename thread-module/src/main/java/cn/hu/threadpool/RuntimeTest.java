package cn.hu.threadpool;

public class RuntimeTest {
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        long l = Runtime.getRuntime().totalMemory();
        long l1 = Runtime.getRuntime().maxMemory();
        long l2 = Runtime.getRuntime().freeMemory();
        System.out.println("CPU个数：" + i);
        System.out.println("totalMemory：" + l);
        System.out.println("maxMemory：" + l1);
        System.out.println("freeMemory：" + l2);
    }
}
