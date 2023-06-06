package com.example.notesbackend.controller;

import com.example.notesbackend.exception.ResourceNotFoundException;
import com.example.notesbackend.model.Notes;
import com.example.notesbackend.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/notes/{id}")
    public ResponseEntity<Notes> getNotesById(@PathVariable Long id) {
        Notes notes = notesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note does not exist with id :" + id));
        return ResponseEntity.ok(notes);
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Notes> updateNotesById(@PathVariable Long id, @RequestBody Notes notesDetails) {
        Notes notes = notesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note does not exist with id :" + id));

        notes.setTextBlock(notesDetails.getTextBlock());
        notes.setTitle(notesDetails.getTitle());

        Notes updatedNote = notesRepository.save(notes);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/notes/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteNotes(@PathVariable Long id) {
        Notes notes = notesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note does not exist with id :" + id));

        notesRepository.delete(notes);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
