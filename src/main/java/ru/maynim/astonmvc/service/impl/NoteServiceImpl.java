package ru.maynim.astonmvc.service.impl;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import ru.maynim.astonmvc.entity.Note;
import ru.maynim.astonmvc.repository.NoteRepository;
import ru.maynim.astonmvc.service.NoteService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class NoteServiceImpl implements NoteService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(NoteServiceImpl.class);
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> findAllWithUsers() {
        List<Note> foundNoteList = noteRepository.findAllWithUsers();
        log.debug("Found notes: {}", foundNoteList);
        return foundNoteList;
    }

    @Override
    public Note findById(long id) {
        Note foundNote = noteRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Note with ID: " + id + " was not found");
        });

        log.debug("Found note: {}", foundNote);

        return foundNote;
    }

    @Override
    public void update(long id, Note note) {
        int updatedRows = noteRepository.update(id, note);
        if (updatedRows == 0) {
            throw new EntityNotFoundException("NOte with ID: " + id + " was not found");
        } else {
            log.debug("Note with ID: {} was updated to Note: {}", id, note);
        }
    }

    @Override
    public void deleteById(long id) {
        noteRepository.deleteById(id);

    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }
}
