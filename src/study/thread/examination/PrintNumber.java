package study.thread.examination;

/**
 * @author loongzhang
 * @Description 多线程打印奇数偶数
 * @date 2023-01-10-14:09
 */
public class PrintNumber {
    int count = 1;
    private Object lock = new Object();

    public void printNumber() {
        while (count <= 10) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " 数为" + count++);
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.notifyAll();
            }

        }
    }

    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        new Thread(printNumber::printNumber,"odd").start();
        new Thread(printNumber::printNumber,"even").start();
    }
}
