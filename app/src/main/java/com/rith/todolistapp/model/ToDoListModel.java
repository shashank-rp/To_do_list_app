package com.rith.todolistapp.model;

public class ToDoListModel {
    public Boolean isSelected;
    public String title;

    public ToDoListModel(Boolean isSelected, String title) {
        this.isSelected = isSelected;
        this.title = title;
    }

    public ToDoListModel() {
    }
}
