package com.algaworks.algamoney.api.token;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jsilva on 07/11/2019
 */
@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getMethod().getName().equals("postAccessToken");
    }

    @Override
    public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken oAuth2AccessToken, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        String refreshToken = oAuth2AccessToken.getRefreshToken().getValue();

        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) oAuth2AccessToken;

        HttpServletRequest request = ((ServletServerHttpRequest)serverHttpRequest).getServletRequest();
        HttpServletResponse response = ((ServletServerHttpResponse)serverHttpResponse).getServletResponse();

        addRefreshTokenToCookie(refreshToken, request, response);
        removeRefreshTokenFromBody(token);
        
        return oAuth2AccessToken;
    }

    private void removeRefreshTokenFromBody(DefaultOAuth2AccessToken token) {
        token.setRefreshToken(null);
    }

    private void addRefreshTokenToCookie(String refreshToken, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath(request.getContextPath().concat("/oauth/token"));
        cookie.setMaxAge(3600);

        response.addCookie(cookie);
    }
}
