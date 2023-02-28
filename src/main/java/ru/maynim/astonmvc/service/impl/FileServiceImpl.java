package ru.maynim.astonmvc.service.impl;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import ru.maynim.astonmvc.entity.File;
import ru.maynim.astonmvc.repository.FileRepository;
import ru.maynim.astonmvc.service.FileService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class FileServiceImpl implements FileService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(FileServiceImpl.class);
    private final FileRepository fileRepository;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public List<File> findAllWithNotes() {
        List<File> foundFileList = fileRepository.findAllWithNotes();

        log.debug("Found files: {}", foundFileList);

        return foundFileList;
    }

    @Override
    public File findById(long id) {
        File foundFile = fileRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Note with ID: " + id + " was not found");
        });

        log.debug("Found file: {}", foundFile);

        return foundFile;
    }

    @Override
    public void update(long id, File file) {
        int updatedRows = fileRepository.update(id, file);
        if (updatedRows == 0) {
            throw new EntityNotFoundException("File with ID: " + id + " was not found");
        } else {
            log.debug("File with ID: {} was updated to File: {}", id, file);
        }
    }

    @Override
    public void deleteById(long id) {
        fileRepository.deleteById(id);
    }

    @Override
    public void save(File file) {
        fileRepository.save(file);
    }

    @Override
    public List<File> findAllByNoteId(long id) {
        List<File> foundFileList = fileRepository.findAllByNoteId(id);

        log.debug("Found files: {}", foundFileList);

        return foundFileList;
    }
}
