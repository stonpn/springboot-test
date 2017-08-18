package my.test.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by pengni on 17-8-15.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        File file = new File("/home/pengni/Desktop/up-test");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            model.addAttribute("files", files);
        }

        return "index";
    }
}
