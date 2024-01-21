package com.example.mvvmdatabindingusingjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.mvvmdatabindingusingjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        MyAdapter adapter = new MyAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        viewModel.fetchData(this);

        viewModel.getMyModelList().observe(this, myModels -> {
            if (myModels != null) {
                adapter.setMyModelList(myModels);
            }
        });
    }
}