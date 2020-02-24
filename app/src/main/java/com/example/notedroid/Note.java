package com.example.notedroid;

import java.time.LocalDate;

public class Note {

    private String title, content;
    private LocalDate createDate, editDate;

    public Note(String title, String content, LocalDate createDate, LocalDate editDate) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.editDate = editDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }
}
