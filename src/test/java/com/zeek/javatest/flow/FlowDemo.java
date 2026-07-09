package com.zeek.javatest.flow;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowDemo {

    /**
     * 1、Publisher（发布者）：发布数据的对象
     * 2、Subscriber（订阅者）：订阅数据的对象
     * 3、Subscription（订阅关系）：发布者和订阅者之间的订阅关系
     * 4、Processor（处理器）：既是发布者又是
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        // 1、定义一个发布者； 发布数据
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();


        // 2、定义一个订阅者； 订阅感兴趣的数据
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<String>() {

            private Flow.Subscription subscription;

            // 在订阅时 onXxxx: 在xxx事件发生时，执行这个回调
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println(Thread.currentThread().getName() + ",订阅开始了" + subscription);
                this.subscription = subscription;

                // 订阅完成后，马上从上游请求一个数据
                this.subscription.request(1);
            }

            // 在下一个元素到达时； 执行这个回调； 接受到了新数据
            @Override
            public void onNext(String item) {
                System.out.println(Thread.currentThread().getName() + ",接收到新数据：" + item);

                this.subscription.request(1);

                // 也可以在指定的时机取消订阅
//                if (item.equals("p-7")) {
//                    this.subscription.cancel();
//                } else {
//                    // 继续从上游请求一个数据
//                    this.subscription.request(1);
//                }
            }

            // 在错误发生时
            @Override
            public void onError(Throwable throwable) {
                System.out.println(Thread.currentThread().getName() + ",发生了错误：" + throwable.getMessage());
            }

            // 在完成时
            @Override
            public void onComplete() {
                System.out.println(Thread.currentThread().getName() + ",完成了");
            }
        };
        // 再定义一个订阅者；并且这个订阅者消费数据慢
        Flow.Subscriber<String> subscriber2 = new Flow.Subscriber<String>() {

            private Flow.Subscription subscription;

            // 在订阅时 onXxxx: 在xxx事件发生时，执行这个回调
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println(">>>,订阅开始了" + subscription);
                this.subscription = subscription;

                // 订阅完成后，马上从上游请求一个数据
                this.subscription.request(1);
            }

            // 在下一个元素到达时； 执行这个回调； 接受到了新数据
            @Override
            public void onNext(String item) {
                System.out.println(">>>,接收到新数据：" + item);

                this.subscription.request(1);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // 也可以在指定的时机取消订阅
//                if (item.equals("p-7")) {
//                    this.subscription.cancel();
//                } else {
//                    // 继续从上游请求一个数据
//                    this.subscription.request(1);
//                }
            }

            // 在错误发生时
            @Override
            public void onError(Throwable throwable) {
                System.out.println(">>>,发生了错误：" + throwable.getMessage());
            }

            // 在完成时
            @Override
            public void onComplete() {
                System.out.println(">>>,完成了");
            }
        };

        // 3、绑定发布者和订阅者的关系
        publisher.subscribe(subscriber);
        publisher.subscribe(subscriber2);


        System.out.println(Thread.currentThread().getName() + "发布数据的线程");
        // 发布数据
        for (int i = 0; i < 10; i++) {

            publisher.submit("p-" + i);

//            if (i >= 9) {
//                // 当发布者异常了后，会触发订阅者的onError回调
//                publisher.closeExceptionally(new RuntimeException("发布者异常了"));
//            } else {
//                publisher.submit("p-" + i);
//            }
            // publisher 发布的所有数据在它的buffer区（其实是一个数组）
        }

        //
        publisher.close();

        // JVM对于整个发布订阅关系做好了 异步+缓存区处理 = 响应式系统


        Thread.sleep(200_000);

    }
}
