package study.thread.createthread;

/**
 * @author lenovo
 * @Description: TODO
 * @date 27/2/2024 下午 4:06
 */
public class MyRunnable implements java.lang.Runnable {
    int count=1;
    @Override
    public void run() {
        System.out.println("喵喵 我是小喵喵"+count++);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true){
            System.out.println("喵喵 我是小喵喵"+count++);
            if (count>=10){
                break;
            }
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

    }

}
