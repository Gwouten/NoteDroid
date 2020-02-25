package com.example.notedroid.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notedroid.R;
import com.example.notedroid.model.Note;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    // ViewHolder
    class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;
        private final TextView tvEditDate;
        private final Button btnDeleteNote;
        private final View cardView;

        private View.OnClickListener ReadNoteHandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();

                Bundle data = new Bundle();
                data.putSerializable("selectedNote", items.get(position));

                Navigation.findNavController(v).navigate(R.id.list_to_note, data);
            }
        };

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_note_title);
            tvEditDate = itemView.findViewById(R.id.tv_note_edit_date);
            btnDeleteNote = itemView.findViewById(R.id.btn_note_delete);
            cardView = itemView.findViewById(R.id.cv_card);

            cardView.setOnClickListener(ReadNoteHandler);
        }
    }

    // Data
    ArrayList<Note> items;

    public NoteAdapter(){
        items = new ArrayList<>();
    }

    // Noodzakelijke methods om te overschrijven
    @NonNull
    @Override
    // layout voor een enkele notitie linken aan lijst
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View card = layoutInflater.inflate(R.layout.note, parent, false);
        return new NoteViewHolder(card);
    }

    @Override
    // data invullen in elk item in een lijst
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = items.get(position);
        holder.tvTitle.setText(currentNote.getTitle());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            holder.tvEditDate.setText(currentNote.getEditDate().format(DateTimeFormatter.ofPattern("dd MM yyyy")));
        }
    }

    @Override
    // Aantal notities meegeven
    public int getItemCount() {
        return items.size();
    }

    public void addItems(ArrayList<Note> notes){
        items.addAll(notes);
    }
}
