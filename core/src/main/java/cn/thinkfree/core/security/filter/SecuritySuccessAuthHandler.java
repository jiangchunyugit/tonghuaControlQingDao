package cn.thinkfree.core.security.filter;


import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.event.EventGenerator;
import cn.thinkfree.core.event.model.UserLoginAfter;
import cn.thinkfree.core.security.filter.util.SecurityRequestUtil;
import cn.thinkfree.core.security.model.SecurityUser;
import cn.thinkfree.core.security.utils.JwtUtils;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class SecuritySuccessAuthHandler
        extends SimpleUrlAuthenticationSuccessHandler {


    private boolean forwardToDestination = false;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Autowired
    EventGenerator eventGenerator;

    @Value("${custom.userService.useCache}")
    Boolean useCache;


    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {

        String targetUrl = determineTargetUrl(request, response);
        if (response.isCommitted()) {
            this.logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        SecurityUser user = (SecurityUser) authentication.getPrincipal();

        eventGenerator.publish(new UserLoginAfter(user.getUsername(),user.getPhone(),SecurityRequestUtil.getRequestIp(request)));

        cacheUserVO(user);
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String,Object> userModel = new HashMap<>();
        userModel.put("username",user.getUsername());
        userModel.put("companyName",user.getCompanyName());
        userModel.put("name",user.getName());
        userModel.put("createTime",(user.getCreateTime() !=null) ?user.getCreateTime().getTime() : null);
        result.put("userModel",userModel);
        String token = jwtUtils.generateToken(user);
        result.put("token","Bearer "+token);

        sendAjaxResult(request,response,result);
    }

    /**
     * 存入缓存
     * @param user
     */
    private void cacheUserVO(SecurityUser user) {
        if(useCache){
            redisTemplate.opsForValue().set(user.getPhone(),user,12,TimeUnit.HOURS);
        }
    }

    /**
     * 发送回执
     * 用于应对AJAX提交
     *
     * @param request
     * @param response
     * @param result
     * @throws IOException
     */
    private void sendAjaxResult(HttpServletRequest request, HttpServletResponse response, Map<String, Object> result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        MyRespBundle<Map<String,Object>> resp = new MyRespBundle<>();
        resp.setTimestamp(Instant.now().toEpochMilli());
        resp.setMsg("登录成功!");
        resp.setCode(1000);
        resp.setData(result);
        response.getWriter().write(new GsonBuilder().serializeNulls().create().toJson(resp));

    }

    protected final void saveMessage(HttpServletRequest request, Map<String, Object> result) {
        if (result == null) {
            return;
        }
        if (isUseForward()) {
            for (String key : result.keySet()) {
                request.setAttribute(key, result.get(key));
            }
        } else {
            HttpSession session = request.getSession(true);
            if (session != null) {
                for (String key : result.keySet()) {
                    request.getSession().setAttribute(key, result.get(key));
                }
            }
        }
    }


    protected boolean isUseForward() {
        return this.forwardToDestination;
    }

    protected boolean isUseForward(HttpServletRequest request) {
        String redirect = request.getParameter("_redirect");
        if (redirect != null) {
            if (redirect.equals("1")) {
                return false;
            }
            if (redirect.equals("0")) {
                return true;
            }
        }
        return this.forwardToDestination;
    }

    public void setUseForward(boolean forwardToDestination) {
        this.forwardToDestination = forwardToDestination;
    }

}

