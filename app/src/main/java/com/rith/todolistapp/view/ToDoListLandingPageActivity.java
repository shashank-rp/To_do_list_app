package com.rith.todolistapp.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.rith.todolistapp.R;
import com.rith.todolistapp.databinding.ActivityToDoListLandingPageBinding;

public class ToDoListLandingPageActivity extends AppCompatActivity {

    ActivityToDoListLandingPageBinding activityToDoListLandingPageBinding;

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
    }

    private void setupOnClickListeners() {
    }

    private void setupObservables() {
    }
}