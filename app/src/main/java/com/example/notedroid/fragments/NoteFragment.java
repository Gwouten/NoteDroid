package com.example.notedroid.fragments;


import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.notedroid.R;
import com.example.notedroid.model.Note;

import java.time.format.DateTimeFormatter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoteFragment extends Fragment {

    private TextView tvCreatedDate, tvEditDate, tvContent;

    public NoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_note_detail, container, false);

        tvCreatedDate = rootView.findViewById(R.id.tv_detail_created_date);
        tvEditDate = rootView.findViewById(R.id.tv_detail_date_edited);
        tvContent = rootView.findViewById(R.id.tv_detail_content);

        Bundle receivedData = getArguments();

        if(receivedData != null){
            if(receivedData.containsKey("selectedNote")){
                Note note = (Note) receivedData.getSerializable("selectedNote");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    tvCreatedDate.setText(note.getCreateDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    tvEditDate.setText(note.getEditDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
                tvContent.setText(note.getContent());
            }
        }

        return rootView;
    }

}
