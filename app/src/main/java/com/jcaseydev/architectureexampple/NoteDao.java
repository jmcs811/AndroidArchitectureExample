package com.jcaseydev.architectureexampple;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/***************
 * *****DAO*****
 ***************/

@Dao
public interface NoteDao {

    // operation methods for table
    // insert, update, delete from table
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    // custom operation to delete all notes
    // "DELETE * FROM note_table
    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    // custom operation to get all notes
    // using livedata on the list of notes
    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();

}
