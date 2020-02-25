package com.example.notedroid.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.notedroid.R;
import com.example.notedroid.model.Note;
import com.example.notedroid.model.NoteViewModel;
import com.example.notedroid.utils.NoteAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment {

    private EditText etNewNoteTitle, etNewNoteContent;
    private Button btnSaveNote;

    private View.OnClickListener saveNoteHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String newTitle = etNewNoteTitle.getText().toString();
            String newContent = etNewNoteContent.getText().toString();

            NoteViewModel model = new ViewModelProvider(getActivity()).get(NoteViewModel.class);
            model.addItems(new Note(newTitle, newContent));
        }
    };

    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_create, container, false);

        etNewNoteTitle = rootView.findViewById(R.id.et_note_title);
        etNewNoteContent = rootView.findViewById(R.id.et_note_content);
        btnSaveNote = rootView.findViewById(R.id.btn_save_note);
        btnSaveNote.setOnClickListener(saveNoteHandler);

        return rootView;
    }

}
