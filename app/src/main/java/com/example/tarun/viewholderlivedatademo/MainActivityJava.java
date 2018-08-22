package com.example.tarun.viewholderlivedatademo;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.tarun.viewholderlivedatademo.bean.UserBean;
import com.example.tarun.viewholderlivedatademo.viewmodel.MyViewModelJava;

public class MainActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        MyViewModelJava viewModelJava = ViewModelProviders.of(this).get(MyViewModelJava.class);
        viewModelJava.getUsers().observe(this, users -> {
            // update UI
            for(UserBean userBean : users) {
                Log.i("Name", userBean.getUserName());
            }
        });
    }
}
