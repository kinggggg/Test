package com.zeek.reactor;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.function.Consumer;

import org.junit.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2021-02-02
 */
public class ReactorTest2 {

    @Test
    public void merge() {
        // todo 下面的输出是0. 为什么????
        Flux.interval(Duration.ofSeconds(0), Duration.ofSeconds(10))
                .take(3)
                .subscribe(System.out::println);

    }

    @Test
    public void takeLast() {
        Flux.range(1, 100)
                .takeLast(10)
                .subscribe(System.out::println);
    }

    @Test
    public void take() {
        Flux.range(1, 100)
                .take(10)
                .subscribe(System.out::println);
    }

    @Test
    public void last() {
        Flux.range(1, 5)
                .last()
                .subscribe(System.out::println);
    }

//    @Test
//    public void first() {
//        Flux.range(1, 5)
//                .first()
//                .subscribe(System.out::println);
//    }

    @Test
    public void window() {
        Flux.range(1, 5)
                .window(2)
                .toIterable()
                .forEach(w -> {
                    w.subscribe(System.out::println);
                    System.out.println("-----");
                });
    }

    @Test
    public void map() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS ");

        // TODO 两种方式得到的结果是一样的. 执行性能上有什么不同呢?
        Flux.range(1, 10).map(ele -> {
//            System.out.println(simpleDateFormat.format(new Date()));
            return ele * ele;
        }).subscribe(System.out::println);

        Flux.range(1, 10).flatMap(ele -> {
//            System.out.println(simpleDateFormat.format(new Date()));
            return Mono.just(ele * ele);
        }).subscribe(System.out::println);
    }

    @Test
    public void buffer() {
        Flux.range(1, 50)
                .buffer(10)
                .subscribe(System.out::println);
    }

    @Test
    public void create() {
        Flux.create(sink -> {
            System.out.println(sink);
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
        }).subscribe(System.out::println);
    }

    @Test
    public void generate() {

        // 第一种写法.
        Consumer<SynchronousSink<String>> generator = sink -> {
            System.out.println(sink);
            sink.next("hello");
            sink.complete();
        };
        Flux.generate(generator).subscribe(System.out::println);

        // 第二种简化的写法. 之所以能这么写要得益于Java的类型推断系统
//        Flux.generate(sink -> {
//            System.out.println(sink);
//            sink.next("hello");
//            sink.complete();
//        }).subscribe(System.out::println);
    }

    @Test
    public void never() {
        Flux.never().subscribe(ele -> System.out.println("never"));
    }

    @Test
    public void error() {
        Flux.error(new NullPointerException("空指针异常")).subscribe(ele -> System.out.println("error"));
    }

    @Test
    public void empty() {
        Flux.empty().subscribe(ele -> System.out.println("empty"));
    }
}
