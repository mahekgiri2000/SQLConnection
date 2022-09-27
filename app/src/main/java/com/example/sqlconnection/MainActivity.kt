package com.example.sqlconnection

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

//    Initialize lateinit variable

    lateinit var sname : EditText
    lateinit var  ssmae : EditText
    lateinit var  bclear : Button
    lateinit var  rs : Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Initialize all the widgets using findViewById()

        sname = findViewById(R.id.name)
        ssmae = findViewById(R.id.same)
        bclear = findViewById(R.id.btnClear)

        var btninsert = findViewById<Button>(R.id.BtnInsert)
        var btnupdate = findViewById<Button>(R.id.BtnDelete)
        var btndelete = findViewById<Button>(R.id.BtnDelete)
        var btnnext = findViewById<Button>(R.id.BtnNext)
        var btnpriv = findViewById<Button>(R.id.BtnPrev)
        var btnfirst = findViewById<Button>(R.id.BtnFirst)
        var btnlast = findViewById<Button>(R.id.BtnLast)
        var btnAll = findViewById<Button>(R.id.BtnShowall)
        var listAll = findViewById<ListView>(R.id.list_item)

//  Create object of MyDBHelper

        var helper = MySQLHelper(applicationContext)
        var db = helper.writableDatabase
        rs = db.rawQuery("SELECT SID _id,SNAME,SEM FROM STUDENTDATA", null)

        bclear.setOnClickListener{
            clear()
        }

//  EditText after clearText()
        if(rs.moveToNext()){
            sname.setText(rs.getString(1))
            ssmae.setText(rs.getString(2))
        }

    }
    private fun clear(){
        sname.setText("")
        ssmae.setText("")
        sname.requestFocus()
    }
}