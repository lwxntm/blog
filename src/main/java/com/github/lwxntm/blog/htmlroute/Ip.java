package com.github.lwxntm.blog.htmlroute;

import com.github.lwxntm.blog.utils.QueryIp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ip {
    @GetMapping("ip")
    public static String getIp(Model model) {
        model.addAttribute("title", "QueryIp");
        return "ip";
    }

    @PostMapping("ip")
    @ResponseBody
    public static String postIp(Model model,
                                @RequestParam("url") String url) {

        model.addAttribute("title", "IpResult");
        model.addAttribute("content", "Your name is ");
        return QueryIp.handleRawStrThenGetIpInfo(url);
    }

}
