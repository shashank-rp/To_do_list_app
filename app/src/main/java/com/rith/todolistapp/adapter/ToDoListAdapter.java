package com.rith.todolistapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rith.todolistapp.R;
import com.rith.todolistapp.databinding.ItemToDoSingleCardBinding;
import com.rith.todolistapp.model.ToDoListModel;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder>{
    Context context;
    Listener listener;
    List<ToDoListModel> listModels = new ArrayList<>(Arrays.asList(new ToDoListModel(true,"hi"),new ToDoListModel(true,"dfsfsfsfs"),new ToDoListModel(true,"sdfsfsfs")));
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
        ToDoListModel toDoListModel = listModels.get(position);
        if(StringUtils.isNotBlank(toDoListModel.title)){
            holder.binding.txtToDoTitle.setText(toDoListModel.title);
        }
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        ItemToDoSingleCardBinding binding;
        Listener listener;
        public ViewHolder(@NonNull ItemToDoSingleCardBinding itemView,Listener listener) {
            super(itemView.getRoot());
            this.binding = itemView;
            this.listener= listener;
        }
    }

    public ToDoListAdapter setListModels(List<ToDoListModel> listModels) {
        this.listModels = listModels;
        notifyDataSetChanged();
        return this;
    }

    public interface Listener{

    }


}
