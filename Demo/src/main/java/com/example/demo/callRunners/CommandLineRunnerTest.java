package com.example.demo.callRunners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerTest implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunnerTest");
    }
}
