package com.github.lwxntm.blog.restservice;

import com.github.lwxntm.blog.pojo.Greeting;
import com.github.lwxntm.blog.utils.ClientIpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xiaotian
 */
@Controller
public class GreetingController {
    public static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, Model model, HttpServletRequest request) {
        String s1 = new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name)).toString();
        String ip = "Your Ip address is " + ClientIpUtil.getIpAddr(request);
        String content = s1 + "\n" + ip;
        model.addAttribute("content", content);
        model.addAttribute("title", "blog");
        return "blog";
    }

}
