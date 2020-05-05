package com.github.lwxntm.blog.htmlroute;

import com.github.lwxntm.blog.TelegramHandler;
import com.github.lwxntm.blog.utils.ClientIpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaotian
 */
@Controller
public class Main {
    @GetMapping("/main")
    public static String mainPage(Model model, HttpServletRequest request) {
        String ip = "Your Ip address is " + ClientIpUtil.getIpAddr(request);
        model.addAttribute("content", ip);
        model.addAttribute("title", "MyBlog");
        new TelegramHandler().sendMessage("爷爷，有人访问你网站啦！");
        return "blog";
    }

    @RequestMapping(value = "/getIp", method = RequestMethod.GET)
    @ResponseBody
    public String getIp(HttpServletRequest request) {
        return ClientIpUtil.getIpAddr(request);
    }

    @GetMapping("/")
    @ResponseBody
    public static String wrk(){
        return "Hello";
    }
}
