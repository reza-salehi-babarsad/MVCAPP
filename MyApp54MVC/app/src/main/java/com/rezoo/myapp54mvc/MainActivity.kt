package com.rezoo.myapp54mvc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rezoo.myapp54mvc.Adapter.CustomAdapter
import com.rezoo.myapp54mvc.Controller.EmployeeController
import com.rezoo.myapp54mvc.DataBase.MYDBAdapter
import com.rezoo.myapp54mvc.View.IemployeeView

class MainActivity : AppCompatActivity(),IemployeeView {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById<RecyclerView>(R.id.recyclerview)
        val employeeController=EmployeeController(this,this)
        employeeController.showAllEmployee()
        



    }

    override fun ShowInfo(arrayList: ArrayList<ItemVieModel>) {
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter=CustomAdapter(arrayList)
        recyclerView.adapter=adapter

    }
}