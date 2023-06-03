package com.example.notesbackend.model;

import jakarta.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "textblock")
    private String textBlock;

    public Notes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextBlock() {
        return textBlock;
    }

    public void setTextBlock(String textBlock) {
        this.textBlock = textBlock;
    }
}
