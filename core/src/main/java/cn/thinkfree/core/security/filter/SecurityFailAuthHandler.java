package cn.thinkfree.core.security.filter;

import cn.thinkfree.core.bundle.MyRespBundle;
import com.google.gson.Gson;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

/**
 *
 */
public class SecurityFailAuthHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        super.onAuthenticationFailure(request, response, exception);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json;charset=utf-8");
        exception.printStackTrace();
        MyRespBundle<String> result = new MyRespBundle<>();
        if(exception instanceof DisabledException){
            result.setData("您的账号还未启用，请联系管理员启用账号后才可登录!");
            result.setMsg("您的账号还未启用，请联系管理员启用账号后才可登录!");
        }else{
            result.setData("登录失败!");
            result.setMsg("登录失败!");
        }
        result.setCode(500);
        result.setTimestamp(Instant.now().toEpochMilli());

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Content-Type","application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(new Gson().toJson(result));
    }
}
