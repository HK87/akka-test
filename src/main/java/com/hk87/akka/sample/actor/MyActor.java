package com.hk87.akka.sample.actor;

import akka.actor.UntypedAbstractActor;

public class MyActor extends UntypedAbstractActor {
    @Override
    public void onReceive(Object msg) {
        if (msg instanceof String) {
            System.out.println(String.format("told '%s' from %s", msg, getSender().toString()));
            System.out.println(sender().toString());
            sender().tell("msg is done!!", self());
        } else {
            System.out.println("unhandled");
        }
    }
}
