package com.example.chotu.secretnotes;

/**
 * Created by Chotu on 2/6/2016.
 */
public class Note {
    private String noteTitle;
    private String noteContent;

    public Note(String noteTitle, String noteContent) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteContent(String noteContent) {

        this.noteContent = noteContent;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }
}
