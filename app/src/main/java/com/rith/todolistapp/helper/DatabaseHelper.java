package com.rith.todolistapp.helper;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rith.todolistapp.dao.ToDoListDao;
import com.rith.todolistapp.model.ToDoList;

@Database(entities = ToDoList.class,exportSchema = false,version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    public abstract ToDoListDao toDoListDao();
    private static final String DB_NAME = "to_do";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext()
            , DatabaseHelper.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
