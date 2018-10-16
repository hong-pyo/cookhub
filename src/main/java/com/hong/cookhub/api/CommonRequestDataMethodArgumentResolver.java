package com.hong.cookhub.api;

import com.hong.cookhub.model.common.CommonRequestData;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by hong2 on 2018. 10. 15.
 * Time : PM 11:35
 */

public class CommonRequestDataMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return CommonRequestData.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpSession session = webRequest.getNativeRequest(HttpServletRequest.class).getSession(false);

        String userAgent = webRequest.getHeader(HttpHeaders.USER_AGENT);
        String sessionId = Optional.ofNullable(session).map(HttpSession::getId).orElse(null);

        return CommonRequestData.builder()
                .sessionId(sessionId)
                .userAgent(userAgent)
                .build();
    }
}
