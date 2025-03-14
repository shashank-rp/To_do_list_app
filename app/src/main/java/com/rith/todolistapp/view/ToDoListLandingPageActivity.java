package com.rith.todolistapp.view;

import static java.util.Objects.nonNull;

import android.app.ActionBar;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.textfield.TextInputLayout;
import com.rith.todolistapp.R;
import com.rith.todolistapp.adapter.ToDoListAdapter;
import com.rith.todolistapp.databinding.ActivityToDoListLandingPageBinding;
import com.rith.todolistapp.databinding.ItemToDoSingleCardBinding;
import com.rith.todolistapp.helper.DatabaseHelper;
import com.rith.todolistapp.model.ToDoList;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ToDoListLandingPageActivity extends AppCompatActivity implements ToDoListAdapter.Listener{

    ActivityToDoListLandingPageBinding activityToDoListLandingPageBinding;
    ToDoListAdapter toDoListAdapter;
    DatabaseHelper databaseHelper;

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
        databaseHelper = DatabaseHelper.getInstance(this);
        showItems();
    }

    private void setupOnClickListeners() {
        activityToDoListLandingPageBinding.btnAddToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog m = new Dialog(ToDoListLandingPageActivity.this);
                m.setContentView(R.layout.item_add_to_do_card);
                Window window = m.getWindow();
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                TextInputLayout ip = m.findViewById(R.id.txtInptToDo);
                Button ok = m.findViewById(R.id.btnOk);
                Button cancel = m.findViewById(R.id.btnCancel);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(StringUtils.isBlank(ip.getEditText().getText().toString())){
                            ip.setError("Enter to do");
                        }else {
                            addItem(ip.getEditText().getText().toString());
                            showItems();
                            m.dismiss();
                        }
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        m.dismiss();
                    }
                });
                m.show();

            }
        });
    }

    private void showItems() {
        List<ToDoList> toDoLists =  databaseHelper.toDoListDao().getAllToDoList();
        toDoListAdapter.setListModels(toDoLists);

    }

    private void addItem(String m){
        databaseHelper.toDoListDao().addToDo(new ToDoList(false,m));
        Toast.makeText(this, m, Toast.LENGTH_SHORT).show();
    }

    private void setupObservables() {
    }

    @Override
    public void onDeletePressed(ToDoList toDoList) {

    }

    @Override
    public void onChecked(ToDoList toDoList) {
        databaseHelper.toDoListDao().updateToDo(toDoList);
        Toast.makeText(this, toDoList.title+" "+toDoList.isSelected, Toast.LENGTH_SHORT).show();
    }
}