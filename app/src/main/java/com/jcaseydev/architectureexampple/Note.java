package com.jcaseydev.architectureexampple;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/****************
 * ****ENTITY****
 ****************/

//change name of table
@Entity(tableName = "note_table")
public class Note {

    //fields of table
    @PrimaryKey(autoGenerate = true)
    private int id; // unique key that is auto generated

    private String title;

    private String description;

    private int priority;

    // constructor and setter for unique key
    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    // getters for all fields
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
