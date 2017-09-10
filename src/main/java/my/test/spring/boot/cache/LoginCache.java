package my.test.spring.boot.cache;

import my.test.spring.boot.util.RedisClient;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class LoginCache {

    @Inject
    private RedisClient redisClient;

    private final static String ERROR_TIME_KEY = "ERROR_TIMES";

    private final static String JSESSIONID = "JSES";

    public void setLoginErrorTimes(String key, String value, int expire) {
        redisClient.setEx(key + ERROR_TIME_KEY, value, expire);
    }

    public String getLoginErrorTimes(String key) {
        return redisClient.get(key + ERROR_TIME_KEY);
    }

    public void setLoginToken(String key, String value, int expire) {
        redisClient.setEx(key + JSESSIONID, value, expire);
    }

    public String getLoginToken(String key) {
        return redisClient.get(key + JSESSIONID);
    }
}
