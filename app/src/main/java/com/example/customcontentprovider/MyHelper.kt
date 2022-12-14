package com.example.customcontentprovider

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context): SQLiteOpenHelper(context, "SIDDESH", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE SIDDESH (_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, MEANING TEXT)")
        db?.execSQL("INSERT INTO SIDDESH (NAME, MEANING) VALUES('Siddesh', 'Siddesh Naik')")
        db?.execSQL("INSERT INTO SIDDESH (NAME, MEANING) VALUES('Siddesh1', 'Siddesh Naik 1')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}