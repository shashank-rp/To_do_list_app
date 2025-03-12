package com.rith.todolistapp.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rith.todolistapp.R;
import com.rith.todolistapp.adapter.ToDoListAdapter;
import com.rith.todolistapp.databinding.ActivityToDoListLandingPageBinding;

public class ToDoListLandingPageActivity extends AppCompatActivity implements ToDoListAdapter.Listener{

    ActivityToDoListLandingPageBinding activityToDoListLandingPageBinding;
    ToDoListAdapter toDoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityToDoListLandingPageBinding = DataBindingUtil.setContentView(ToDoListLandingPageActivity.this,R.layout.activity_to_do_list_landing_page);
        getActivityIntent();
        initUI();
        setupOnClickListeners();
        setupObservables();
        
    }

    private void getActivityIntent() {
    }

    private void initUI() {
        toDoListAdapter = new ToDoListAdapter(this,this);
        activityToDoListLandingPageBinding.rvToDo.setLayoutManager(new LinearLayoutManager(this));
        activityToDoListLandingPageBinding.rvToDo.setAdapter(toDoListAdapter);
    }

    private void setupOnClickListeners() {
    }

    private void setupObservables() {
    }
}