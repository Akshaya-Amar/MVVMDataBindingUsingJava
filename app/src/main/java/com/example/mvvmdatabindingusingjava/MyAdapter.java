package com.example.mvvmdatabindingusingjava;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmdatabindingusingjava.databinding.ListItemsBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<MyModel> myModelList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemsBinding binding = ListItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyModel myModel = myModelList.get(position);
        holder.binding.setMyModel(myModel);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return myModelList.size();
    }

    public void setMyModelList(List<MyModel> myModelList) {
        this.myModelList = myModelList;
        notifyDataSetChanged();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        final ListItemsBinding binding;

        MyViewHolder(ListItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}