package com.example.notedroid.model;

import android.os.Build;

import java.time.LocalDate;

public class Note {

    private String title, content;
    private final LocalDate createDate;
    private LocalDate editDate;

    private LocalDate makeCreateDate(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDate.now();
        }
        return null;
    }

    private LocalDate makeEditDate(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDate.now();
        }
        return null;
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createDate = makeCreateDate();
        this.editDate = makeEditDate();
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

    public void setEditDate(LocalDate editDate) {
        this.editDate = editDate;
    }

    public LocalDate getEditDate() {
        return editDate;
    }
}
