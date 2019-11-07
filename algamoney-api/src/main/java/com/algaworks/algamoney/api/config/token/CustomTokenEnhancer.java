package com.algaworks.algamoney.api.config.token;

import com.algaworks.algamoney.api.security.ApiUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jsilva on 07/11/2019
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        ApiUser apiUser = (ApiUser) authentication.getPrincipal();

        Map<String, Object> addInfo = new HashMap<>();
        addInfo.put("name", apiUser.getUser().getName());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);

        return accessToken;
    }
}
