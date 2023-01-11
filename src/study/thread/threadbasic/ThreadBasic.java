package study.thread.threadbasic;

import java.util.Date;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2023-01-09-10:04
 */
public class ThreadBasic extends Thread{
    public ThreadBasic(String name){
        this.setName(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(currentThread().getName()+" 执行次数"+i);
            try {
                this.wait();
                this.notifyAll();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        Thread a = new ThreadBasic("A");
        Thread b = new ThreadBasic("B");
        System.out.println(new Date());
        a.start();
        b.start();
    }

}
