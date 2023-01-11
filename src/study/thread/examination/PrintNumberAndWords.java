package study.thread.examination;

/**
 * @author loongzhang
 * @Description function : one thread print number other thread print words
 * @date 2023-01-10-14:54
 */
public class PrintNumberAndWords {
    int count = 26;
    int charFlag = 0;
    int number = 0;
    private Object lock = new Object();

    public void print(String target) {
        while (count >= 0) {
            synchronized (lock) {
                if (target.equals(Thread.currentThread().getName())) {
                    System.out.println(Thread.currentThread().getName() + number);
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("111" + (char) ((charFlag++) + 'A'));
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                lock.notifyAll();
                count--;
                number++;
            }


        }

    }

    public static void main(String[] args) {
        PrintNumberAndWords printNumberAndWords = new PrintNumberAndWords();
        new Thread(() -> {
            printNumberAndWords.print("number");
        }, "number").start();
        new Thread(() -> {
            printNumberAndWords.print("words");
        }, "words").start();
    }
}
