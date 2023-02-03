package com.zeek.javatest.completablefuture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by weibo_li on 2017/2/14.
 */
public class CompletableFutureTest {

    @Test
    public void thread_exception_test() {

        new Thread(() -> {
            System.out.println("aaa");
        }).start();


    }

    @Test
    public void name3() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 1;
        });
        CompletableFuture<Integer> c2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep2");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 2;
        });
        CompletableFuture<Integer> c3 = CompletableFuture.supplyAsync(() -> {
            {
                try {
                    System.out.println("sleep3");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return 3;
            }
        });
        CompletableFuture<Integer> c4 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep4");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 4;
        });

        List<CompletableFuture<Integer>> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        System.out.println("正在join. join的时间是最长的任务执行时间");
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0]))
                .thenApply(it -> {
                    System.out.println(it);
                    List<Integer> collect = list.stream().map(ele -> {
                        System.out.println("ele=" + ele);
                        return ele.join();
                    }).collect(Collectors.toList());
                    System.out.println("collect" + collect);
                    return collect;
                })
                .join();
        System.out.println("结束join. ");

        System.out.println("阻塞式顺序获取任务结果");
        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());
        System.out.println(c4.get());
    }

    @Test
    public void name2() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 1;
        });
        CompletableFuture<Integer> c2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep2");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 2;
        });
        CompletableFuture<Integer> c3 = CompletableFuture.supplyAsync(() -> {
            {
                try {
                    System.out.println("sleep3");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return 3;
            }
        });
        CompletableFuture<Integer> c4 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep4");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 4;
        });

        List<CompletableFuture<Integer>> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        System.out.println("正在join. join的时间是最长的任务执行时间");
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        System.out.println("结束join. ");

        System.out.println("阻塞式顺序获取任务结果");
        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());
        System.out.println(c4.get());
    }

    @Test
    public void name() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("1");
            return 1;
        });
        CompletableFuture<Integer> c2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep2");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("2");
            return 2;
        });
        CompletableFuture<Integer> c3 = CompletableFuture.supplyAsync(() -> 3);
        CompletableFuture<Integer> c4 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("sleep4");
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 4;
        });

        System.out.println("正在join. join的时间是最长的任务执行时间");
        CompletableFuture.allOf(c1, c2, c3, c4).join();
        System.out.println("结束join. ");

        System.out.println("阻塞式顺序获取任务结果");
        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());
        System.out.println(c4.get());
    }

    private static Shop shop = null;

    private static List<Shop> shops;

    private static final Executor executer = Executors.newFixedThreadPool(4, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    @BeforeClass
    public static void init() {
        shop = new Shop("shop-one");
    }

    @BeforeClass
    public static void initShops() {
        shops = Arrays.asList(new Shop(" BestPrice"), new Shop(" LetsSaveBig"), new Shop(" MyFavoriteShop"), new Shop(" BuyItAll"));
    }

    @Test
    public void testGetPriceAsync() throws Exception {
        CompletableFuture<Double> futurePrice = this.getPriceAsync("product-name");
        System.out.println(futurePrice.get());

        long start = System.currentTimeMillis();
        System.out.println(this.findPrices3("product-name"));
        long end = System.currentTimeMillis();
        long time0 = (end - start);
        System.out.println(String.format("执行了 %s 时间", (end - start)));

        start = System.currentTimeMillis();
        System.out.println(this.findPrices2("product-name"));
        end = System.currentTimeMillis();
        long time1 = (end - start);
        System.out.println(String.format("执行了 %s 时间", (end - start)));

        start = System.currentTimeMillis();
        System.out.println(this.findPrices1("product-name"));
        end = System.currentTimeMillis();
        System.out.println(String.format("ִ执行了 %s 时间", (end - start)));
        long time2 = (end - start);

        start = System.currentTimeMillis();
        System.out.println(this.findPrices0("product-name"));
        end = System.currentTimeMillis();
        System.out.println(String.format("ִ执行了 %s 时间", (end - start)));
        long time3 = (end - start);

        System.out.println(time3 - time2);

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public List<String> findPrices0(
            String product) {
        return shops.stream().map(shop ->
                CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.calculatePrice(product))).map(CompletableFuture::join).collect(Collectors.toList());

    }

    public List<String> findPrices1(
            String product) {
        return shops.parallelStream().map(shop ->
                CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.calculatePrice(product))).map(CompletableFuture::join).collect(Collectors.toList());

    }

    public List<String> findPrices2(
            String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop ->
                CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.calculatePrice(product))).collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public List<String> findPrices3(
            String product) {
        List<CompletableFuture<String>> priceFutures = shops.parallelStream().map(shop ->
                CompletableFuture.supplyAsync(() -> shop.getName() + " price is " + shop.calculatePrice(product), executer)).collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }


    //同步计算价格方法
    public double getPrice(String product) {
        return shop.calculatePrice(product);
    }

    //异步计算价格方法
    public CompletableFuture<Double> getPriceAsync(String product) throws Exception {

        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            double price = shop.calculatePrice(product);
            futurePrice.complete(price);
        }).start();

        //System.out.println(futurePrice.get());

        return futurePrice;
    }

}

