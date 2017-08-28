package my.test.spring.boot.common.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pengni on 17-8-18.
 */
@Aspect
public class RestInterceptor {

    @Pointcut("@within(org.springframework.stereotype.Controller)")
    private void anyMethod(){}

    @Around("anyMethod()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] request = joinPoint.getArgs();
        if (request != null && request.length > 0) {
            if (request[0] instanceof HttpServletRequest) {
                System.out.println("this is httprequest");
                System.out.println(request.length);
            }
        }
        Object result = joinPoint.proceed();
        System.out.println("after");
        return result;
    }

}
