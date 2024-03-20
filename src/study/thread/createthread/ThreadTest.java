package study.thread.createthread;

/**
 * @author lenovo
 * @Description: TODO
 * @date 27/2/2024 下午 3:54
 */
public class ThreadTest extends Thread{
     int count =1;
    @Override
    public void run() {
        while (count<=10){
            System.out.println("喵喵 我是小喵喵"+count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();


    }
}
