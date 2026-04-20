class MyRunnable implements Runnable{
    Thread t;
    public MyRunnable(String tName){
        t = new Thread(this, tName);
        System.out.println("Child Thread"+t);
        t.start();
    }
    public void run(){
        for (int i=0; i<10;i++){
            try{
                Thread.sleep(1000);
                System.out.println(t.getName()+" "+i);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class Example2MultiThreading {
    public static void main(String[] args) {
        new MyRunnable("1st");
        new MyRunnable("2nd");
    }
    
}
