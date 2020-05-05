package com.github.lwxntm.blog.htmlroute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiaotian
 */
@Controller
public class GetPrimeNumber {
    @GetMapping("/prime")
    public static String primeIndex(Model model) {
        model.addAttribute("title", "素数计算");
        model.addAttribute("content", "请访问/prime/{nth}");
        return "blog";
    }

    @GetMapping("/prime/{nth}")
    public static String prime(@PathVariable("nth") int i, Model model) {
        model.addAttribute("title", "素数计算");
        if (i > 1) {
            String res = primeI(i);
            model.addAttribute("content", res);
        } else {
            model.addAttribute("content", "请求不合法");
        }
        return "blog";

    }

    private static int nthPrime(int n) {
        int i = 3, j = 1;
        while (true) {
            j = j + 2;
            if (j * j > i) {
                n = n - 1;
                if (n == 1) {
                    break;
                }
                i = i + 2;
                j = 1;
            } else if (i % j == 0) {
                i = i + 2;
                j = 1;
            }
        }
        return i;
    }

    private static String primeI(int n) {
        long s = System.currentTimeMillis();
        int result = nthPrime(n);
        long time = System.currentTimeMillis() - s;
        return "第" + n + "个素数的值是:" + result + " 耗时" + time + " ms";
    }
}
