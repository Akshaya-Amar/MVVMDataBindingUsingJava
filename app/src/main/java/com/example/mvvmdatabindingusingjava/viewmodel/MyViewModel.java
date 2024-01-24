package com.example.mvvmdatabindingusingjava.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mvvmdatabindingusingjava.model.MyModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {

    private final MutableLiveData<List<MyModel>> myModelList = new MutableLiveData<>();

    public LiveData<List<MyModel>> getMyModelList() {
        return myModelList;
    }

    public void fetchData(Context context) {

        String url = "https://jsonplaceholder.typicode.com/users";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    List<MyModel> models = new ArrayList<>();
                    try {
                        for (int i = 0; i < response.length(); i++) {

                            JSONObject jsonObject = response.getJSONObject(i);
                            String name = jsonObject.getString("name");
                            String email = jsonObject.getString("email");
                            String website = jsonObject.getString("website");

                            MyModel model = new MyModel(name, email, website);
                            models.add(model);
                        }
                        myModelList.setValue(models);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.e("error", error.toString())
        );

        Volley.newRequestQueue(context).add(jsonArrayRequest);
    }
}