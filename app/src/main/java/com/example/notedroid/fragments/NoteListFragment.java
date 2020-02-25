package com.example.notedroid.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notedroid.R;
import com.example.notedroid.model.NoteViewModel;
import com.example.notedroid.utils.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteListFragment extends Fragment {

    private FloatingActionButton btnCreateNote;

    private View.OnClickListener newNoteHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Navigation.findNavController(v).navigate(R.id.list_to_create_note);
        }
    };

    public NoteListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_note_list, container, false);

        btnCreateNote = rootView.findViewById(R.id.btn_new_note);
        btnCreateNote.setOnClickListener(newNoteHandler);

        RecyclerView rvNotes = rootView.findViewById(R.id.rv_notes);
        RecyclerView.LayoutManager manager;

        manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rvNotes.setLayoutManager(manager);

        final NoteAdapter adapter = new NoteAdapter();
        rvNotes.setAdapter(adapter);

        NoteViewModel model = new ViewModelProvider(getActivity()).get(NoteViewModel.class);
        model.getNotes().observe(getViewLifecycleOwner(), (jokes)->{adapter.addItems(jokes);});

        return rootView;
    }

}
