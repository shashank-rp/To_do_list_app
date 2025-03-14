package com.rith.todolistapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "todolist")
public class ToDoList {
    @ColumnInfo(name = "is_selected")
    public Boolean isSelected;
    @ColumnInfo(name = "title")
    @NonNull
    public String title;
    @PrimaryKey(autoGenerate = true)
    private int id;
    public ToDoList(Boolean isSelected, @NonNull String title) {
        this.isSelected = isSelected;
        this.title = title;
    }
    public ToDoList(Boolean isSelected,@NonNull  String title,int id) {
        this.isSelected = isSelected;
        this.title = title;
        this.id = id;
    }

    public ToDoList() {
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
