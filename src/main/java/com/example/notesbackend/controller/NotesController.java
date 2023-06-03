package com.example.notesbackend.controller;

import com.example.notesbackend.model.Notes;
import com.example.notesbackend.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class NotesController {

    @Autowired
    private NotesRepository notesRepository;

    @GetMapping("/notes")
    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    @PostMapping("/notes")
    public Notes createNotes(@RequestBody Notes notes) {
        return notesRepository.save(notes);
    }

}
