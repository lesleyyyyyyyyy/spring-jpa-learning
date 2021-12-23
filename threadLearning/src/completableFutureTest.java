import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author xin.hao
 * @create 2021/1/15 14:02
 * <p>
 * CompletableFuture 启动异步任务
 */
public class completableFutureTest {
    public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        System.out.println("main...start.....");


        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("This Thread\'s id : " + Thread.currentThread().getId());
            System.out.println("Result = " + (10 / 2));
        }, executor);

        System.out.println("main...end.....");

    }
}
