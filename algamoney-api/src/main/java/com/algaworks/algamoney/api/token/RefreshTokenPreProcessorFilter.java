package com.algaworks.algamoney.api.token;

import org.apache.catalina.util.ParameterMap;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author jsilva on 07/11/2019
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RefreshTokenPreProcessorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        if ("/oauth/token".equalsIgnoreCase(req.getRequestURI())
                && "refresh_token".equals(req.getParameter("grant_type"))
                && req.getCookies() != null) {

            String refreshToken =
                    Stream.of(req.getCookies())
                            .filter(cookie -> "refreshToken".equals(cookie.getName()))
                            .findFirst()
                            .map(Cookie::getValue)
                            .orElse(null);

            req = new MyServletRequestWrapper(req, refreshToken);
        }

        chain.doFilter(request, response);

    }

    private static class MyServletRequestWrapper extends HttpServletRequestWrapper {
        private String refreshToken;

        public MyServletRequestWrapper(HttpServletRequest req, String refreshToken) {
            super(req);
            this.refreshToken = refreshToken;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            ParameterMap<String, String[]> parameterMap = new ParameterMap<>(getRequest().getParameterMap());
            parameterMap.put("refresh_token", new String[]{refreshToken});
            parameterMap.setLocked(true);
            return super.getParameterMap();
        }
    }
}
