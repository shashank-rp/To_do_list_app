package com.rith.todolistapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.rith.todolistapp.databinding.ActivityMainBinding;
import com.rith.todolistapp.view.ToDoListLandingPageActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
        Intent intent = new Intent(this, ToDoListLandingPageActivity.class);
        startActivity(intent);

    }
}