package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens

       
//        ReactiveSources.intNumbersFluxWithException()
//                .subscribe(
//                        num -> System.out.println(num + " received"),
//                        err -> System.out.println("Oops! error occured" + err)
//                );
//
//        //another approach - below error handling shows the actual error
//
//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(err -> System.out.println("Error " + err))
//                .subscribe(num -> System.out.println(num + " received"));
//
//        // Print values from intNumbersFluxWithException and continue on errors
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((err, item) -> System.out.println("Error " + err))
//                .subscribe(num -> System.out.println(num + " received"));
//
//        // Print values from intNumbersFluxWithException and when errors
//        // happen, replace with a fallback sequence of -1 and -2
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorResume(err -> Flux.just(-1, -2))
//                .subscribe(num -> System.out.println(num + " received"));

        //finally test
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .doFinally(signalType -> {
                    if (signalType.equals(SignalType.ON_COMPLETE))
                        System.out.println("Completed");
                    if (signalType.equals(SignalType.ON_ERROR))
                        System.out.println("In progress");
                })
                .subscribe(num -> System.out.println(num + " received"));

        System.out.println("Press a key to end");
        System.in.read();
    }
}
