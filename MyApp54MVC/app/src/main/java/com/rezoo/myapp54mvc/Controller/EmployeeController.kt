package com.rezoo.myapp54mvc.Controller

import android.content.Context
import com.rezoo.myapp54mvc.Model.Employee
import com.rezoo.myapp54mvc.View.IemployeeView

class EmployeeController(private  val context: Context,private val iemployeeView: IemployeeView):IemployeeController {
    override fun showAllEmployee() {
        val employee=Employee(context )
        val fInfo=employee.AllEmployee()
        iemployeeView.ShowInfo(fInfo)
    }
}