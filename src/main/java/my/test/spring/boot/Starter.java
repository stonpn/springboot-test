package my.test.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by pengni on 17-6-20.
 */
@SpringBootApplication
@ComponentScan(basePackages="my.test.spring.boot")
public class Starter {

    public static void main(String[] s) {
        SpringApplication.run(Starter.class, s);
    }
}
