package study.thread.threadbasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2023-01-09-10:13
 */
public class MyRunnable implements Runnable {
    private Object syncWait = new Object();
    private final Integer number=10;

    static List<Integer> numberList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread aThread = new Thread(new MyRunnable(), "A线程");
        Thread bThread = new Thread(new MyRunnable(), "B线程");
        // 设置线程优先级
        aThread.setPriority(Thread.MIN_PRIORITY);
        aThread.start();
        bThread.start();
        // 主线程等待两个线程分别执行完成
        aThread.join();
        bThread.join();
        System.out.println("当前List的总容量" + numberList.size());

    }
    @Override
    public void run() {
        synchronized (number) {
            forTest();
            //numberListAdd();


        }

    }

    /**
     * 测试for循环添加
     */
    void forTest(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if (i==5){
                System.out.println("线程中断开始"+Thread.currentThread().getName());
                Thread.interrupted();
            }
            /**
             *  yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
             *  因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
             *  但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
             */
            //Thread.yield();

        }
    }

    /**
     * 测试往List中添加数据
     */
    void numberListAdd(){
        for (int i = 0; i < 100; i++) {
            numberList.add(new Random().nextInt(100));
            if (numberList.size()==10){
                System.out.println("当前线程睡眠开始"+numberList.size());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(" 当前线程睡眠结束"+numberList.size());
            }
        }

    }

}
