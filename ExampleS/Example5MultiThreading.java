/*ThreadPriorityDemo Example5MultiThreading*/
public class ThreadPriorityDemo extends Thread {
    public ThreadPriorityDemo(String tName) {
        super(tName);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                sleep(200);
                System.out.println("Call of " + this.getName() + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPriorityDemo t1 = new ThreadPriorityDemo("Low");
        t1.setPriority(Thread.MIN_PRIORITY); // 1
        ThreadPriorityDemo t2 = new ThreadPriorityDemo("High");
        t2.setPriority(Thread.MAX_PRIORITY); // 10
        t1.start();
        t2.start();
    }
}

/*
 * public class Example5MultiThreading {
 * 
 * }
 */
