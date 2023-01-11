package study.thread.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABCUsingLock {

    private int times; // 控制打印次数
    private int state;   // 当前状态值：保证三个线程之间交替打印
    private static int countAllPrint;

    private Lock lock = new ReentrantLock();
    private static List<String> list=new ArrayList<>();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetNum) {

        for (int i = 0; i  < times;){
            /**
             * 实现思路,如果当前线程取余三得到的是想打印的线程,那么就打印
             * 并且实现计数加
             * 若果当前线程不符合,释放锁,让其他线程进行相应的操作
             * 思路简单  操作太low
             */
             lock.lock();
             if (state % 3 == targetNum) {
                 state++;
                 i++;
                 countAllPrint++;
                 System.out.print(name);
                 list.add(name);
            }
            lock.unlock();
        }
        /**
         * A B C A B C A B C A B C A B C
         * A B C A B C A B C A B C A B C
         */
    }

    public static void main(String[] args) throws InterruptedException {

        //顺序打印10次
        PrintABCUsingLock loopThread = new PrintABCUsingLock(10);



        new Thread(() -> {
            loopThread.printLetter("B", 1);
        }, "B").start();
        new Thread(() -> {
            loopThread.printLetter("A", 0);
        }, "A").start();
        
        new Thread(() -> {
            loopThread.printLetter("C", 2);
        }, "C").start();
        Thread.sleep(4000);
        System.out.println();
        System.out.println("总打印次数"+countAllPrint+"   list中的总容量"+list.size());
    }

}

