package my.test.spring.boot.util;

import my.test.spring.boot.cache.LoginCache;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class LoginChecker {

    @Inject
    private LoginCache loginCache;

    public boolean checkLogin(HttpServletRequest request) {
        String jsId = getJsId(request);
        if (jsId == null) {
            return false;
        }
        if (loginCache.getLoginToken(jsId) != null) {
            return true;
        }
        return false;

    }

    public String getJsId(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String jsId = null;
        if (cookies == null) {
            jsId = request.getSession().getId();
            return jsId;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                jsId = cookie.getValue();
                break;
            }
        }
        return jsId;
    }
}
