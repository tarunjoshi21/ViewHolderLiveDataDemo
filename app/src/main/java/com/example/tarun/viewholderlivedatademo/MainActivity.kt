package com.example.tarun.viewholderlivedatademo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.tarun.viewholderlivedatademo.viewmodel.MyViewModelKT

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myViewModelJava = ViewModelProviders.of(this).get(MyViewModelKT::class.java)
        myViewModelJava.getUsers().observe(this, Observer { users->
            users!!.forEach { Log.e("Username", it.userName) }
        })
    }
}
