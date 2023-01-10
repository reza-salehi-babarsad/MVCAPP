package com.rezoo.myapp54mvc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var textview=findViewById<TextView>(R.id.textView)
        val email=intent.getStringExtra("p").toString()
        textview.setText(email)
        var edittextsubject=findViewById<EditText>(R.id.editTextTextsubject)
        var edittextbody=findViewById<EditText>(R.id.editTextTextbody)
        var buttonsend=findViewById<Button>(R.id.buttonsend)
        buttonsend.setOnClickListener {
            val intent= Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            val address=email.split(",".toRegex()).toTypedArray()
            val subject=edittextsubject.text
            val message=edittextbody.text

            intent.putExtra(Intent.EXTRA_EMAIL,address)
            intent.putExtra(Intent.EXTRA_SUBJECT,"$subject")
            intent.putExtra(Intent.EXTRA_TEXT,message)
            startActivity(Intent.createChooser(intent,"SEND EMAIL"))
        }


    }

}