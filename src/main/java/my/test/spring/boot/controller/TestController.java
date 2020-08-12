package my.test.spring.boot.controller;

import my.test.spring.boot.mapper.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;

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


    @RequestMapping("/rest")
    public String rest(HttpServletRequest request) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("a","123");
        map.add("b", "3456");
        String u = "http://127.0.0.1:8079/pay/rest";
        URI url = UriComponentsBuilder.fromHttpUrl("http://127.0.0.1:8079/pay/rest").build().encode().toUri();
        HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.POST, req, String.class);
        return res.getBody();

    }

}
