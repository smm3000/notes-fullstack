package com.example.notesbackend.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NotesTest {

    private Notes notes;

    @Before
    public void setUp() {
        notes = new Notes();
    }

    @Test
    public void testSetAndGetId() {
        Long id = 1L;
        notes.setId(id);
        Assert.assertEquals(id, notes.getId());
    }

    @Test
    public void testSetAndGetTitle() {
        String title = "testTitle";
        notes.setTitle(title);
        Assert.assertEquals(title, notes.getTitle());
    }

    @Test
    public void testSetAndGetTextBlock() {
        String textblock = "test message";
        notes.setTextBlock(textblock);
        Assert.assertEquals(textblock, notes.getTextBlock());
    }

    @Test
    public void testDefaultConstructors() {
        Assert.assertNotNull(notes);
    }



}
