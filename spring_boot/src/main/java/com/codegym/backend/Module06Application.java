package com.codegym.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Pattern;

@SpringBootApplication
public class Module06Application {

    public static void main(String[] args) {
        String name = "dong@gmail.com";
        String regexName = "[a-zA-Z][a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        if (Pattern.compile(regexName).matcher(name).find()){
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }
        SpringApplication.run(Module06Application.class, args);
    }

}
