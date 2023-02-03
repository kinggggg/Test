//package com.zeek.javatest.actor.akka;
//
//import akka.actor.ActorRef;
//import akka.actor.ActorSystem;
//import akka.actor.Props;
//import akka.actor.UntypedActor;
//
///**
// * @ClassName HelloActor
// * @Description
// * @Author liweibo
// * @Date 2019/9/23 11:00 AM
// * @Version v1.0
// **/
//public class HelloActor extends UntypedActor {
//
//    public static void main(String[] args) {
//
//        //创建Actor系统
//        ActorSystem system = ActorSystem.create("HelloSystem");
//        //创建HelloActor
//        ActorRef helloActor =
//                system.actorOf(Props.create(HelloActor.class));
//        //发送消息给HelloActor
//        helloActor.tell("Actor", ActorRef.noSender());
//
//    }
//
//    @Override
//    public void onReceive(Object message) {
//        System.out.println("Hello	" + message);
//    }
//}
