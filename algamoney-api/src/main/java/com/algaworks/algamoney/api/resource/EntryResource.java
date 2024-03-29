package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.data.search.filter.EntryFilter;
import com.algaworks.algamoney.api.event.ResourceCreatedEvent;
import com.algaworks.algamoney.api.logic.bean.EntryDTO;
import com.algaworks.algamoney.api.logic.service.entry.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author jsilva on 31/10/2019
 */
@RestController
@RequestMapping("/api/v1/entry")
public class EntryResource {

    private EntryService entryService;

    private ApplicationEventPublisher publisher;

    @Autowired
    public EntryResource(EntryService entryService, ApplicationEventPublisher publisher) {
        this.entryService = entryService;
        this.publisher = publisher;
    }

    @GetMapping
    public Page<EntryDTO> listAll(EntryFilter filter, Pageable pageable) {
        return entryService.search(filter, pageable);
    }

    @PostMapping
    public ResponseEntity<EntryDTO> add(@RequestBody @Valid EntryDTO entryDTO, HttpServletResponse response) {
        EntryDTO savedEntry = entryService.add(entryDTO);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedEntry.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntry);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable("id") Long id) {
        entryService.remove(id);
    }
}
