class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Child Thread " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*public class Example3MultiThreading {
    public static void main(String[] ar) {
        new MyRunnable("1st");
        new MyRunnable("2nd");
    }
}*/