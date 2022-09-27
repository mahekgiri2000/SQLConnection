package com.example.sqlconnection

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLHelper(context: Context) : SQLiteOpenHelper (context, "STUDENTDATA", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE STUDENTDATA (SID INTEGER PRIMARY KEY AUTOINCREMENT, SNAME TEXT, SEM NUMBER)")
        p0?.execSQL("INSERT INTO STUDENTDATA (SNAME,SEM) VALUES ('MAHEK',3)")
        p0?.execSQL("INSERT INTO STUDENTDATA (SNAME,SEM) VALUES ('NIRAJ',4)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }


}