import java.util.concurrent.*;

/**
 * @Author xin.hao
 * @create 2021/1/14 10:12
 * <p>
 * 异步   多线程
 * <p>
 * 区别 ：
 * - 1、2 不能得到返回值，3可获得返回值；
 * - 1、2、3都不能控制资源；
 * - 4可以控制资源，性能稳定
 */
public class threadTest {

    //创建线程池
    private static ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        System.out.println("main...start.....");
        //1) 继承Thread -- 启动
/*
        Thread01 thread01 = new Thread01();
        thread01.start();   //启动线程
*/

        //2) 实现 Runnable 接口    -- 启动
/*
        Runnable02 runnable01 = new Runnable02();
        new Thread(runnable01).start();
*/

        //3) 实现 Callable 接口    -- 启动
/*
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable01());
        new Thread(futureTask).start();
        //阻塞 等待整个线程执行完成，获取返回结果
        Integer integer = null;
        try {
            integer = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
*/

        // 4) 线程池   --给线程池提交任务
        service.execute(new Runnable01());


        System.out.println("main...end.....");

    }

    /**
     * 1) 继承 Thread 类
     */
    public static class Thread01 extends Thread {
        @Override
        public void run() {
            System.out.println("This Thread\'s id : " + Thread.currentThread().getId());
            System.out.println("Result = " + (10 / 2));
        }
    }

    /**
     * 2) 实现 Runnable 接口
     */
    public static class Runnable01 implements Runnable {
        @Override
        public void run() {
            System.out.println("This Thread\'s id : " + Thread.currentThread().getId());
            System.out.println("Result = " + (10 / 2));
        }
    }

    /**
     * 3) 实现 Callable 接口
     */
    public static class Callable01 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("This Thread\'s id : " + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("Result = " + i);
            return i;
        }
    }


}
