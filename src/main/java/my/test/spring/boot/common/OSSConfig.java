//package my.test.spring.boot.common;
//
//import com.aliyun.oss.OSSClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//public class OSSConfig {
//
//    @Value("${oss.aliyun.endpoint}")
//    private String ossEndpoint;
//
//    @Value("${oss.aliyun.accessKeyId}")
//    private String accessKeyId;
//
//    @Value("${oss.aliyun.accessKeySecret}")
//    private String accessKeySecret;
//
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//    public OSSClient ossClient() {
//        return new OSSClient(ossEndpoint, accessKeyId, accessKeySecret);
//    }
//
//}
