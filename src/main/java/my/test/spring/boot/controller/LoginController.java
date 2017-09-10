package my.test.spring.boot.controller;

import my.test.spring.boot.cache.LoginCache;
import my.test.spring.boot.util.LoginChecker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private final static String PASSWORD = "qazxsw";

    private final static String NOT_LOGIN_URL = "redirect:/login";

    @Inject
    private LoginCache loginCache;

    @Inject
    private LoginChecker loginChecker;

    @RequestMapping("/do-login")
    public String login(HttpServletRequest request) {
        if (loginChecker.checkLogin(request)) {
            return NOT_LOGIN_URL;
        }
        String jsId = loginChecker.getJsId(request);
        String token = loginCache.getLoginToken(jsId);
        if (token != null) {
            return NOT_LOGIN_URL;
        }
        String errorTimeStr = loginCache.getLoginErrorTimes(jsId);
        if (errorTimeStr != null && Integer.parseInt(errorTimeStr) >= 3) {
            return NOT_LOGIN_URL;
        }
        if (errorTimeStr == null) {
            errorTimeStr = "0";
        }
        String password = request.getParameter("pass");
        if (password == null) {
            return NOT_LOGIN_URL;
        }
        if (password.equalsIgnoreCase(PASSWORD)) {
            loginCache.setLoginToken(jsId, "1", 7200);
            String callback = request.getParameter("callback");
            if (callback != null) {
                return "redirect:" + callback;
            }
            return "index";
        } else {
            loginCache.setLoginErrorTimes(jsId, String.valueOf(1 + Integer.parseInt(errorTimeStr)), 7200);
            return NOT_LOGIN_URL;
        }
    }

    @RequestMapping("/login")
    public String loginPage(HttpServletRequest request, Model model) {
        String callBack = request.getParameter("callback");
        model.addAttribute("callback", callBack);
        return "login";
    }

}
