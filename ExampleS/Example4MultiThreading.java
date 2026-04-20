public class MyRunner {
    public static void main(String[] ar) {
        MyRunnable m = new MyRunnable();
        Thread t = new Thread(m);
        t.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Master " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * public class public class Example4MultiThreading {
 * 
 * }
 */