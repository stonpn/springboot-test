package my.test.spring.boot.common;


import my.test.spring.boot.common.interceptor.RestInterceptor;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.servlet.MultipartConfigElement;

/**
 * Created by pengni on 17-8-14.
 */
@Configuration
@PropertySource({"classpath:config/param.properties"})
public class SpringConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("20480KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("204800KB");
        return factory.createMultipartConfig();
    }

    @Bean
    public RestInterceptor restInterceptor() {
        return new RestInterceptor();
    }
}
