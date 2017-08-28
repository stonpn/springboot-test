package my.test.spring.boot.test;

import org.springframework.stereotype.Component;

@Component(value = "testA")
public class Test {

    public void printName(String name) {
        System.out.println("printName:" + name);
    }

}
