package com.rith.todolistapp.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rith.todolistapp.R;
import com.rith.todolistapp.databinding.ItemToDoSingleCardBinding;
import com.rith.todolistapp.model.ToDoList;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder>{
    Context context;
    Listener listener;
    List<ToDoList> listModels = new ArrayList<>(Arrays.asList(new ToDoList(true,"hi"),new ToDoList(true,"dfsfsfsfs"),new ToDoList(true,"sdfsfsfs")));
    public ToDoListAdapter(Context context,Listener listener){
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemToDoSingleCardBinding itemToDoSingleCardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_to_do_single_card,parent,false);
        return new ViewHolder(itemToDoSingleCardBinding,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ToDoList toDoList = listModels.get(position);
        holder.model = toDoList;
        if(StringUtils.isNotBlank(toDoList.title)){
            holder.binding.txtToDoTitle.setText(toDoList.title);
        }
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        ItemToDoSingleCardBinding binding;
        Listener listener;
        ToDoList model;
        public ViewHolder(@NonNull ItemToDoSingleCardBinding itemView,Listener listener) {
            super(itemView.getRoot());
            this.binding = itemView;
            this.listener= listener;

            binding.chkBoxToDo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked)
                        binding.txtToDoTitle.setPaintFlags(binding.txtToDoTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    else binding.txtToDoTitle.setPaintFlags(binding.txtToDoTitle.getPaintFlags() ^ Paint.STRIKE_THRU_TEXT_FLAG);
                    model.setSelected(isChecked);
                    listener.onChecked(model);
                }
            });
        }
    }

    public ToDoListAdapter setListModels(List<ToDoList> listModels) {
        this.listModels = listModels;
        notifyDataSetChanged();
        return this;
    }

    public interface Listener{
        void onDeletePressed(ToDoList toDoList);
        void onChecked(ToDoList toDoList);
    }


}
