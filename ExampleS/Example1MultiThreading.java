class MyThread extends Thread {
    public void run(){
        for (int i=0; i<100; i++){
            System.out.println("Call No ="+i);
            try{
                sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class Example1MultiThreading {
    public static void main(String[] args){
        MyThread m = new MyThread();
        m.start();
    }
}