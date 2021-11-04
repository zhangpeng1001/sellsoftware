package com.tw.sellsoftware.utils.intercepter;

import com.tw.sellsoftware.usercenter.domain.LoginToken;
import com.tw.sellsoftware.usercenter.service.LoginService;
import com.tw.sellsoftware.utils.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final String login_url = "/login";
    private final LoginService loginService;

    public LoginInterceptor(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        Optional<LoginToken> optional = loginService.getLoginTokenByToken(token);
        if (!optional.isPresent())response.sendRedirect(login_url);
        request.setAttribute(Constant.USER_ID,optional.get().getUserId());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
