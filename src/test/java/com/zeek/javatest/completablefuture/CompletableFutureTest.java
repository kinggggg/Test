package com.zeek.javatest.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by weibo_li on 2017/2/14.
 */
public class CompletableFutureTest {

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

