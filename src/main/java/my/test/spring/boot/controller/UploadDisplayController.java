package my.test.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadDisplayController {

    @RequestMapping("/up2")
    public String displaySex(HttpServletRequest request) {
        return "upload-s";
    }
}
