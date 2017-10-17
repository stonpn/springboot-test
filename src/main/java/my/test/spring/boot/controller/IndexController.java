package my.test.spring.boot.controller;

import my.test.spring.boot.common.model.MemberModel;
import my.test.spring.boot.mapper.TestMapper;
import my.test.spring.boot.util.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by pengni on 17-8-15.
 */
@Controller
public class IndexController {

    @Inject
    private RedisClient redisClient;

    @Inject
    private TestMapper testMapper;

    private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        MemberModel memberModel = testMapper.selectById(1);
        System.out.println(memberModel);
        LOGGER.info("redis get:{}", redisClient.get("a"));
        File file = new File("/home/pengni/Desktop/up-test");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            model.addAttribute("files", files);
        }

        return "index";
    }

    @RequestMapping("/myfamily")
    public String myFamily(HttpServletRequest request) {
        return "myfamily";
    }
}
