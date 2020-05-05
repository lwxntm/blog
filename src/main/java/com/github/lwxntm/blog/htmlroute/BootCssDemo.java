package com.github.lwxntm.blog.htmlroute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xiaotian
 */
@Controller
public class BootCssDemo {
    @GetMapping("/bs")
    public static String bs(Model model){
        model.addAttribute("title","BootCssDemo");
        return "bsdemo";
    }
}
