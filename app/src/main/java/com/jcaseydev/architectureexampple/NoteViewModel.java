package com.jcaseydev.architectureexampple;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository mNoteRepository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        mNoteRepository = new NoteRepository(application);
        allNotes = mNoteRepository.getAllNotes();
    }

    public void insert(Note note) {
        mNoteRepository.instert(note);
    }

    public void update(Note note) {
        mNoteRepository.update(note);
    }

    public void delete(Note note) {
        mNoteRepository.delete(note);
    }

    public void deleteAllNotes() {
        mNoteRepository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
