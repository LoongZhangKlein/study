package study.thread.createthread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lenovo
 * @Description: TODO
 * @date 27/2/2024 下午 4:17
 */
public class MyCallable implements java.util.concurrent.Callable {
    int count=0;
    @Override
    public Object call() throws Exception {
        while (true){
            System.out.println("喵喵 我是小喵喵"+count++);
            Thread.sleep(100);
            if (count>=10){
                return "ok";
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask<Object> objectFutureTask = new FutureTask<Object>(myCallable);
        new Thread(objectFutureTask).start();
        Object o = objectFutureTask.get();
        System.out.println("返回结果"+o);
    }
}
