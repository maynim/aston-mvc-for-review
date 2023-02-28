package ru.maynim.astonmvc.repository;

import ru.maynim.astonmvc.entity.File;

import java.util.List;
import java.util.Optional;

public interface FileRepository {

    List<File> findAllWithNotes();

    Optional<File> findById(long id);

    int update(long id, File file);

    void deleteById(long id);

    void save(File file);

    List<File> findAllByNoteId(long id);
}
