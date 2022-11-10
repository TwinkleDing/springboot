package com.example.spring.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Objects;

/**
 * @author TwinkleDing
 */
@Slf4j
public class JwInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 获取请求头的token
        String token = request.getHeader("token");
        log.info("token" + token);

        if (token == null || "".equals(token)) {
            return false;
        }

        // 验证token是否正确
        JwtUtil.checkSign(token);

        String userId = JwtUtil.getUserId(token);
        Map<String, Object> info = JwtUtil.getInfo(token);

//        // 重新设置token
//        JwtUtil.sign(userId, info);
        return true;
    }
}