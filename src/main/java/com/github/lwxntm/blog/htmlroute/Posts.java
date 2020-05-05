package com.github.lwxntm.blog.htmlroute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiaotian
 */
@Controller
public class Posts {
    @GetMapping("/posts/{id}")
    public static String getPosts(@PathVariable("id") String id, Model model) {
        model.addAttribute("title", "Post Page");
        model.addAttribute("content", "你正在查看的页面是：" + id);
        return "blog";
    }
}
