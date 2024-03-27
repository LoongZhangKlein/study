package study.thread.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author loongzhang
 * @Description: TODO
 * @date 25/3/2024 下午 9:56
 */
class HttpHandler implements Runnable {

    @Override
    public void run() {
        System.out.println("当前执行线程名称======" + Thread.currentThread().getName());
    }
}

class LongTask implements Runnable {

    @Override
    public void run() {
        System.out.println("长时间任务正在执行");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(new Date()));
            TimeUnit.SECONDS.sleep(5);
            System.out.println(simpleDateFormat.format(new Date()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        long l = System.currentTimeMillis();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YY-MM-DD:HH:mm:ss");
//        String format = simpleDateFormat.format(new Date());
//        executorService.execute(new HttpHandler());
        Future<?> submit = executorService.submit(new HttpHandler());
//        executorService.execute(new LongTask());
        Future<?> submit1 = executorService.submit(new LongTask());
//        for (int i = 0; i < 100000; i++) {
//            executorService.execute(new HttpHandler());
//        }

//        executorService.shutdown();
//        System.out.println("拒绝提交任务");
        // 方式1
//        while (true) {
//            System.out.println("任务执行中");
//            boolean terminated = executorService.isTerminated();
//            if (terminated) {
//                long l1 = System.currentTimeMillis();
//                String format1 = simpleDateFormat.format(new Date());
//                System.out.println("任务执行完成============" + format + "   " + format1);
//                System.out.println("任务执行完成============" + (l1 - l) / 1000 + "秒");
//                break;
//            }
//        }

        //        try {
//            if (executorService.awaitTermination(2, TimeUnit.SECONDS)) {
//                // 如果1秒内没有执行完毕，则取消所有任务
//                System.out.println("任务执行完成");
//            }else{
//                System.out.println("任务执行失败");
//            }
//        } catch (InterruptedException e) {
//            // 如果等待过程中被中断，也取消所有任务
//            executorService.shutdownNow();
//            Thread.currentThread().interrupt();
//        }
        // 方式2
//        try {
//            boolean b = executorService.awaitTermination(5, TimeUnit.SECONDS);
//            if (b){
//                System.out.println("执行完成");
//            }else {
//                System.out.println("超时结束");
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Object o = submit1.get();

        Object o1 = submit.get();
        System.out.println("执行完成");

    }


}


