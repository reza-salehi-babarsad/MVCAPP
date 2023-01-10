package com.rezoo.myapp54mvc.Model

import android.content.Context
import com.rezoo.myapp54mvc.DataBase.MYDBAdapter
import com.rezoo.myapp54mvc.ItemVieModel

class Employee(private val context: Context):Iemployee {
    override fun AllEmployee(): ArrayList<ItemVieModel> {
        val mydbAdapter=MYDBAdapter(context )
        val employeeInfo=mydbAdapter.Getdata()
        return employeeInfo
    }

}