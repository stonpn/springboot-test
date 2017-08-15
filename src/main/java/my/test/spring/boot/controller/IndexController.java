package my.test.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pengni on 17-8-15.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        return "index";
    }
}
