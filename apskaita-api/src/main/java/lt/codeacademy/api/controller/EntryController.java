package lt.codeacademy.api.controller;


import static lt.codeacademy.api.ApiPath.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lt.codeacademy.api.entity.Client;
import lt.codeacademy.api.entity.Entry;
import lt.codeacademy.api.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ENTRIES)
public class EntryController {
    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    public List<Entry> getEntries() {
        return entryService.getEntries();
    }

    @GetMapping(value = CLIENT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Entry getEntry(@PathVariable(ID_VARIABLE) UUID id) {
        return entryService.getEntry(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEntry(@RequestBody Entry entry) {
        entryService.createEntry(entry);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateEntry(@RequestBody Entry entry) {
        entryService.updateEntry(entry);
    }

    @DeleteMapping(ENTRY)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable(ID_VARIABLE) UUID id) {
        entryService.deleteEntry(id);
    }

    @GetMapping(SEARCH)
    public List<Entry> searchEntries(@RequestParam LocalDate dateFrom, LocalDate dateTill) {
        return entryService.getEntriesByDate(dateFrom, dateTill);
    }

}
