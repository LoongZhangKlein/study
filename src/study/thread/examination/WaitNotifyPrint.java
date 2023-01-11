package study.thread.examination;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2023-01-10-13:50
 */
public class WaitNotifyPrint {
    private int state;
    private int times;
    private static final Object LOCK = new Object();
    public WaitNotifyPrint(int times){
        this.times=times;
    }
    private void printLetter(int targetState) {
        // 实现思路 若果当前线程是targetState则打印当前线程的名字,如果不是阻塞
        for (int i = 0; i < times; i++) {
            synchronized (LOCK){
                // 这里是核心哈
                while (state%3!=targetState){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                state++;
                System.out.print(Thread.currentThread().getName()+"  ");
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        WaitNotifyPrint waitNotifyPrint=new WaitNotifyPrint(10);
        new Thread(()->{waitNotifyPrint.printLetter(0);},"A").start();
        new Thread(()->{waitNotifyPrint.printLetter(1);},"B").start();
        new Thread(()->{waitNotifyPrint.printLetter(2);},"C").start();
    }

}
