package lt.codeacademy.api.service;

import lt.codeacademy.api.entity.Entry;
import lt.codeacademy.api.exception.EntryNotFoundException;
import lt.codeacademy.api.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public void createEntry(Entry entry) {
        entryRepository.save(entry);
    }

    public List<Entry> getEntries() {
        return entryRepository.findAll();
    }

    public Entry getEntry(UUID id) {
        return entryRepository.findById(id).orElseThrow(() -> new EntryNotFoundException(id));
    }

    public List<Entry> getEntriesByDate(LocalDate dateFrom, LocalDate dateTill) {
        return entryRepository.findEntryByDateBetween(dateFrom, dateTill);
    }

    public void updateEntry(Entry entry) {
        entryRepository.save(entry);
    }

    public void deleteEntry(UUID id) {
        entryRepository.deleteById(id);

    }
}
