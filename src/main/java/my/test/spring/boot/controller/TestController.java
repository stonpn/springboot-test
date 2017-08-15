package my.test.spring.boot.controller;

import my.test.spring.boot.mapper.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by pengni on 17-6-20.
 */
@RestController
@RequestMapping("/boot-test")
public class TestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestController.class);

//    @Inject
//    private TestMapper testMapper;

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        LOGGER.info("request in");
        //testMapper.updateById(1);
        return "123";
    }

}
