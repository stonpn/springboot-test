package my.test.spring.boot.common.interceptor;

import my.test.spring.boot.util.LoginChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {

    @Inject
    private LoginChecker loginChecker;

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object var3) throws Exception {
        LOGGER.info(request.getRequestURI());
        LOGGER.info(request.getServerName());
        LOGGER.info("port" + request.getServerPort());
        LOGGER.info(request.getQueryString());
        if (!loginChecker.checkLogin(request)) {
            LOGGER.info("interceptor login");
            String callBack = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();
            response.sendRedirect("/login?callback=" + callBack);
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception {

    }

    public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception {

    }

}
