package com.algaworks.algamoney.api.event.listener;

import com.algaworks.algamoney.api.event.ResourceCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class ResourceCreatedListener implements ApplicationListener<ResourceCreatedEvent> {

    @Override
    public void onApplicationEvent(ResourceCreatedEvent resourceCreatedEvent) {
        addLocationHeader(resourceCreatedEvent.getResponse(), resourceCreatedEvent.getResourceId());
    }

    private void addLocationHeader(HttpServletResponse response, Long resourceId) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(resourceId)
                .toUri();

        response.setHeader("Location", uri.toASCIIString());
    }
}
