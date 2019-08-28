package com.hk87.akka.sample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import com.hk87.akka.sample.actor.MyActor;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]) {
        ActorSystem system = ActorSystem.create("test-system");
        ActorRef myActorRef = system.actorOf(Props.create(MyActor.class), "my-actor");
        try {
            String ret = (String) Await.result(Patterns.ask(myActorRef, "hola", 5000)
                    , Duration.create(5000, TimeUnit.MILLISECONDS));
            myActorRef.tell("hello", ActorRef.noSender());
            System.out.println(ret);
        } catch (Exception e) {
            // TODO
        }
    }
}
