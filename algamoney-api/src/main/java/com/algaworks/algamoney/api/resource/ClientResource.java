package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.event.ResourceCreatedEvent;
import com.algaworks.algamoney.api.logic.bean.ClientDTO;
import com.algaworks.algamoney.api.logic.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/client")
public class ClientResource {

    private final ClientService clientService;

    private ApplicationEventPublisher publisher;

    @Autowired
    public ClientResource(ClientService clientService, ApplicationEventPublisher publisher) {
        this.clientService = clientService;
        this.publisher = publisher;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid ClientDTO clientDTO, HttpServletResponse response) {
        ClientDTO savedClient = clientService.add(clientDTO);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedClient.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable("id") Long id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
