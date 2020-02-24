package com.example.notedroid.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class NoteViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Note>> notes;

    // init single instance of DAO
    private void loadNotes(){
        ArrayList<Note> newNotes = new ArrayList<>();
        newNotes.add(new Note(
                "Welcome to NoteDroid",
                "This is just an example note. You can delete it by pressing the delete button below. Happy noting!"));
        notes.setValue(newNotes);
    }

    public MutableLiveData<ArrayList<Note>> getNotes() {
        if(notes == null){
            notes = new MutableLiveData<>();
            loadNotes();
        }
        return notes;
    }
}
