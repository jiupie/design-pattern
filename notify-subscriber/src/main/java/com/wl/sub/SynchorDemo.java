package com.wl.sub;

/**
 * @author 南顾北衫
 */
public class SynchorDemo {
    private static String s = "";

    public static void lockTest(String s) {
        System.out.println("lock before");
        synchronized (SynchorDemo.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s += s;
            System.out.println(s);
        }
    }


    public void lockTestNostatic(String s) {
        System.out.println("lock before");
        synchronized (this) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s += s;
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                new SynchorDemo().lockTest("i");
//            }).start();
//        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                new SynchorDemo().lockTestNostatic("i");
            }).start();
        }
    }
}
