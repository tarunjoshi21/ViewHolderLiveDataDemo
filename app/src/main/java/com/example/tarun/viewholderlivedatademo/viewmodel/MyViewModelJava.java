package com.example.tarun.viewholderlivedatademo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import com.example.tarun.viewholderlivedatademo.bean.UserBean;

import java.util.ArrayList;
import java.util.List;


public class MyViewModelJava extends ViewModel {
    private MutableLiveData<List<UserBean>> users;
    public LiveData<List<UserBean>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();

            loadUsers();
        }

        return users;
    }

    private void loadUsers() {
        // async operation to fetch users
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            List<UserBean> userBeans = new ArrayList<>();
            UserBean userBean = new UserBean();
            userBean.setUserName("Tarun");
            userBeans.add(userBean);
            userBean = new UserBean();
            userBean.setUserName("Manish");
            userBeans.add(userBean);
            userBean = new UserBean();
            userBean.setUserName("Mohit");
            userBeans.add(userBean);
            userBean = new UserBean();
            userBean.setUserName("Rohit");
            userBeans.add(userBean);
            userBean = new UserBean();
            userBean.setUserName("Sombir");
            userBeans.add(userBean);
            userBean = new UserBean();
            userBean.setUserName("Raj");
            userBeans.add(userBean);

            users.setValue(userBeans);
        }, 2000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
