package com.jz.bigdata.reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {

//        Flux.generate(fluxSink -> {
//            //parallel-1
//            fluxSink.next(Thread.currentThread().getName());
//            fluxSink.complete();
//        }).publishOn(Schedulers.single())
//                //single-1
//                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//                .publishOn(Schedulers.elastic())
//                //elastic-2
//                .map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
//                .subscribeOn(Schedulers.parallel())
//                .toStream()
//                .forEach(System.out::println);


        Flux.range(1, 20)
                .parallel(4)
                .runOn(Schedulers.parallel())
                .subscribe(i -> System.out.println(Thread.currentThread().getName() + " -> " + i));

    }
}
