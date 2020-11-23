package ru.sbrf.cu.executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFutureDemo {
    private static final Logger logger = LoggerFactory.getLogger(CompletableFutureDemo.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //simpleAsync();
        //asyncThen();
        //asyncError();
        //asyncAcceptBoth();
        asyncAcceptEither();
    }

    private static void simpleAsync() throws ExecutionException, InterruptedException {
        logger.info("start");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> task(1));
        logger.info("thread is not blocked");
        logger.info("result:{}", future1.get());
    }

    private static void asyncThen() {
        logger.info("start");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> task(2));
        future2.thenAccept(val -> logger.info("result:{}", val));
        future2.join();
    }

    private static void asyncError() {
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(CompletableFutureDemo::errorAction);
        future3.exceptionally(Throwable::getMessage).thenAccept(msg -> logger.info("msg:{}", msg));
    }

    private static void asyncAcceptBoth() {
        logger.info("start");
        CompletableFuture<String> futureT1 = CompletableFuture.supplyAsync(() -> task(100));
        CompletableFuture<String> futureT2 = CompletableFuture.supplyAsync(() -> task(200));
        CompletableFuture<Void> joinedResult = futureT1.thenAcceptBoth(futureT2, (s1, s2) -> logger.info("joinedResult: {}, {}", s1, s2));
        joinedResult.join();
    }

    private static void asyncAcceptEither() {
        logger.info("start");
        CompletableFuture<String> futureT1 = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return task(100);
        }
    );
    CompletableFuture<String> futureT2 = CompletableFuture.supplyAsync(() -> task(200));
    CompletableFuture<Void> firstResult = futureT1.acceptEither(futureT2, s -> logger.info("firstResult: {}", s));
    firstResult.join();
}

    private static String errorAction() {
        throw new RuntimeException("error for Test");
    }

    private static String task(int id) {
        sleep(5);
        logger.info("task is done: {}", id);
        return "done" + id;
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static class ExecutorServiceDemo {
        private static final Logger logger = LoggerFactory.getLogger(ExecutorServiceDemo.class);

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            //new ExecutorServiceDemo().singleThread();
            //new ExecutorServiceDemo().newFixedThreadPool();
            //new ExecutorServiceDemo().scheduledThreadPoolExecutor();
        }

        private String task(int id) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(3));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            logger.info("call is done:{}", id);
            return "done " + id;
        }

        private void singleThread() throws ExecutionException, InterruptedException {
            //Один поток выполняет задачи из внутренней НЕОГРАНИЧЕННОЙ очереди
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> resultInFuture1 = executor.submit(() -> task(1));
            logger.info("task1 submitted");

            Future<String> resultInFuture2 = executor.submit(() -> task(2));
            logger.info("task2 submitted");

            Future<String> resultInFuture3 = executor.submit(() -> task(3));
            logger.info("task3 submitted");

            String result1 = resultInFuture1.get();
            String result2 = resultInFuture2.get();
            String result3 = resultInFuture3.get();

            logger.info("result1:{}", result1);
            logger.info("result2:{}", result2);
            logger.info("result3:{}", result3);

            executor.shutdown();
        }

        private void newFixedThreadPool() throws ExecutionException, InterruptedException {
            //Заданное количество потоков выполняют задачи из внутренней НЕОГРАНИЧЕННОЙ очереди
            ExecutorService executor = Executors.newFixedThreadPool(3);
            Future<String> resultInFuture1 = executor.submit(() -> task(1));
            logger.info("task1 submitted");

            Future<String> resultInFuture2 = executor.submit(() -> task(2));
            logger.info("task2 submitted");

            Future<String> resultInFuture3 = executor.submit(() -> task(3));
            logger.info("task3 submitted");

            String result1 = resultInFuture1.get();
            String result2 = resultInFuture2.get();
            String result3 = resultInFuture3.get();

            logger.info("result1:{}", result1);
            logger.info("result2:{}", result2);
            logger.info("result3:{}", result3);

            executor.shutdown();
        }

        private void scheduledThreadPoolExecutor() {
            //Заданное количество потоков выполняют задачи с задержкой или периодически
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(() -> logger.info("task is done"), 0, 3, TimeUnit.SECONDS);
        }
    }

    public static class ForkJoinPoolDemo {
        private static final Logger logger = LoggerFactory.getLogger(ForkJoinPoolDemo.class);

        public static void main(String[] args) {
            new ForkJoinPoolDemo().go();
        }

        private void go() {
            ForkJoinPool forkJoinPool = new ForkJoinPool();

            int result = forkJoinPool.invoke(new Task(new int[]{1, 2, 1, 1, 2, 3, 5}));
            logger.info("result:{}", result);
        }

        public static class Task extends RecursiveTask<Integer> {
            private final int[] data;

            Task(int[] data) {
                this.data = data;
                logger.info("data:{}", data);
            }

            @Override
            protected Integer compute() {
                List<Task> subTasks = new ArrayList<>();
                if (this.data.length > 1) {
                    Task taskL = new Task( Arrays.copyOfRange(this.data, 0, this.data.length / 2));
                    taskL.fork();
                    subTasks.add(taskL);

                    Task taskR = new Task(Arrays.copyOfRange(this.data, this.data.length / 2, this.data.length));
                    taskR.fork();
                    subTasks.add(taskR);

                    Integer result = 0;
                    for (Task subTask : subTasks) {
                        result += subTask.join();
                    }
                    return result;
                } else {
                    return this.data[0];
                }
            }
        }
    }
}
