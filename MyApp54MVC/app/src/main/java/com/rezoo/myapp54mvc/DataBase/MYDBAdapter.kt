package com.rezoo.myapp54mvc.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.BitmapFactory
import com.rezoo.myapp54mvc.ItemVieModel

class MYDBAdapter(context: Context) {
    var myDBHelper:MyDBHelper
    init {
        myDBHelper=MyDBHelper(context)
    }
    fun Getdata():ArrayList<ItemVieModel>{
        val DB: SQLiteDatabase =myDBHelper.writableDatabase
        val select:String="select * from Employee"
        val cursor: Cursor =DB.rawQuery(select,null)
        val buffer:StringBuffer=StringBuffer()
        val arrayList=ArrayList<ItemVieModel>()
        while (cursor.moveToNext()){
            val Id :Int=cursor.getInt(0)
            val name=cursor.getString(1)
            val family=cursor.getString(2)
            val address=cursor.getString(3)
            val image=cursor.getBlob(4)
            val email=cursor.getString(5)
            val bmp= BitmapFactory.decodeByteArray(image,0,image.size)
            val itemViewModel=ItemVieModel(bmp,name,family,address,email)
            arrayList.add(itemViewModel)
        }
        return arrayList
    }



    class MyDBHelper(context: Context):
        SQLiteOpenHelper(context,"MyDataBase54MVC",null,1) {
        val context:Context
        init {
            this.context=context
        }

        override fun onCreate(DB: SQLiteDatabase?) {
            val createTable:String="create table Employee (Id Int primary key," +
                    "Name varchar(45))"
            DB?.execSQL(createTable)
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            TODO("Not yet implemented")
        }

    }

}