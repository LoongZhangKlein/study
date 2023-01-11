package study.thread.threadbasic;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2023-01-10-10:37
 */

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock解决顺序打印ABC问题
 */
public class LockSolvePrint {
    private int times;
    private int state;
    private static int countAllPrint;
    private Lock lock = new ReentrantLock();

    public LockSolvePrint(int times) {
        this.times = times;
    }

    public void printLetter(String name, int targetNum) {
        int count=10;
        while (count>0){
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                count--;
                countAllPrint++;
                System.out.print(Thread.currentThread().getName()+" ");
            }
            lock.unlock();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        LockSolvePrint lockSolvePrint = new LockSolvePrint(10);
        //List<Thread> threadsList = new ArrayList<>();
        new Thread(() -> {
            lockSolvePrint.printLetter("A", 0);
        }, "A").start();
        new Thread(() -> {
            lockSolvePrint.printLetter("B", 1);
        }, "B").start();
        new Thread(() -> {
            lockSolvePrint.printLetter("C", 2);
        }, "C").start();
        Thread.sleep(4000);
        System.out.println("总打印次数"+countAllPrint);
    }

}
