package com.example.tarun.viewholderlivedatademo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import com.example.tarun.viewholderlivedatademo.bean.UserBeanKT

class MyViewModelKT : ViewModel() {
    private  var users = MutableLiveData<List<UserBeanKT>>()

    public fun getUsers() : LiveData<List<UserBeanKT>> {
        loadUsers()
        return users
    }

    private fun loadUsers() {
        val runnable = Runnable {
            val userBeans = ArrayList<UserBeanKT>()
            userBeans.add(UserBeanKT("Tarun"))
            userBeans.add(UserBeanKT("Rohit"))
            userBeans.add(UserBeanKT("Mohit"))
            userBeans.add(UserBeanKT("Manish"))
            userBeans.add(UserBeanKT("Sombir"))
            userBeans.add(UserBeanKT("Raj"))

            users.value = userBeans
        }
        val handler = Handler()
        handler.postDelayed(runnable , 2000)
    }

}