package com.enthuzd;

import jakarta.annotation.PostConstruct;

public class HelloService {

    @PostConstruct
    public void init() {
        System.out.println("Hello Service is up!!!!!!");
    }

    public static void sayHello() {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " hello world " + i);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        thread.start();
    }


}