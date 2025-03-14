package com.rith.todolistapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.rith.todolistapp.model.ToDoList;

import java.util.List;

@Dao
public interface ToDoListDao {
    @Insert
    void addToDo(ToDoList toDoList);
    @Delete
    void deleteTo(ToDoList toDoList);
    @Query("Select * from todolist")
    List<ToDoList> getAllToDoList();
    @Update
    void updateToDo(ToDoList toDoList);

}
