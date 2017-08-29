package my.test.spring.boot.common.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pengni on 17-8-18.
 */
@Aspect
public class RestInterceptor {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestInterceptor.class);

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    private void anyMethod(){}

    @Around("anyMethod()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] augments = joinPoint.getArgs();
        if (augments != null && augments.length > 0) {
            HttpServletRequest request = (HttpServletRequest) augments[0];
        }
        Object result = joinPoint.proceed();
        System.out.println("after");
        return result;
    }



}
