package com.algaworks.algamoney.api.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
public class ResourceCreatedEvent extends ApplicationEvent {

    private HttpServletResponse response;

    private Long resourceId;

    public ResourceCreatedEvent(Object source, HttpServletResponse response, Long resourceId) {
        super(source);
        this.response = response;
        this.resourceId = resourceId;
    }
}
