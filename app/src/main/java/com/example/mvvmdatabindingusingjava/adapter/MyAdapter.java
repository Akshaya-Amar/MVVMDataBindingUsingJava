package com.example.mvvmdatabindingusingjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmdatabindingusingjava.databinding.ListItemsBinding;
import com.example.mvvmdatabindingusingjava.model.MyModel;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    private List<MyModel> myModelList = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemsBinding binding = ListItemsBinding.inflate(LayoutInflater.from(context), parent, false);
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
        notifyItemInserted(myModelList.size() - 1);
//        notifyDataSetChanged(); //will refresh the entire dataset and update the entire list when there's a change.
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private final ListItemsBinding binding;

        MyViewHolder(ListItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}