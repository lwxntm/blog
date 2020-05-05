package com.github.lwxntm.blog.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author xiaotian
 */
@RestController
public class RandGen {
    @GetMapping("/rand")
    public static String getRand() {
        return "please visit /rand/{n}";
    }

    @GetMapping("/rand/{n}")
    public static String getRand(@PathVariable("n") int n) {
        return Integer.toString(new Random().nextInt(n)+1);
    }

}
