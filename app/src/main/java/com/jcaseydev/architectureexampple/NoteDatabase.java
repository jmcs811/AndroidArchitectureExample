package com.jcaseydev.architectureexampple;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/***************
 * ***ROOM DB***
 ***************/

// annotate as DB
// use Note.class to specify the fields
@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    // singleton
    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao mNoteDao;

        private PopulateDbAsyncTask(NoteDatabase db) {
            mNoteDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mNoteDao.insert(new Note("Title 1", "Description 1", 1));
            mNoteDao.insert(new Note("Title 2", "Description 2", 2));
            mNoteDao.insert(new Note("Title 3", "Description 3", 3));
            return null;
        }
    }
}
