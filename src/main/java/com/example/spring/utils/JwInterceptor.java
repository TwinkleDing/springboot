package com.example.spring.utils;

import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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

        if (token == null || "".equals(token)) {
            return false;
        }

        // 验证token是否正确
        if (!JwtUtil.checkSign(token)) {
            result(response);
            return false;
        }

        String userId = JwtUtil.getUserId(token);
        Map<String, Object> info = JwtUtil.getInfo(token);

        // 重新设置token
        JwtUtil.sign(userId, info);
        return true;
    }

    private void result(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(200);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Map<String, Object> info = new HashMap<>();
            info.put("status", 401);
            info.put("data", null);
            info.put("message", "token 失效，请重新登录！");
            out.append(JSONObject.toJSONString(info));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            {
                if (out != null) {
                    out.close();
                }
            }
        }
    }
}
